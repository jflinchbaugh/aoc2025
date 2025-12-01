(ns aoc2025.day-1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn rotate [start turn]
  (let [[_ d c] (re-find #"(\w)(\d+)" turn)
        dir-op ({"R" - "L" +} d)
        clicks (parse-long c)]
    (mod (dir-op start clicks) 100)))

(defn part-1 [input]
  (->>
   input
   str/trim
   str/split-lines
   (reductions rotate 50)
   (filter #{0})
   count))

(defn rotate-2 [[start _ _] turn]
  (let [[_ d c] (re-find #"(\w)(\d+)" turn)
        dir-op ({"R" - "L" +} d)
        clicks (parse-long c)]
    [(mod (dir-op start clicks) 100) dir-op clicks]))

(defn times-passed-0 [[current dir-op clicks]]
  (let [times-around (long (/ clicks 100))
        mod-clicks (mod clicks 100)
        start (mod (({- + + -} dir-op) current clicks) 100)]
    (+ times-around
       (cond
         (= 0 current) 1
         (= 0 start) 0
         (and (= + dir-op) (< current start)) 1
         (and (= - dir-op) (> current start)) 1
         :else 0))))

(defn part-2 [input]
  (->>
   input
   str/trim
   str/split-lines
   (reductions rotate-2 [50 + 0])
   (map times-passed-0)
   (reduce + 0)))

(comment
  (->> "input/day-1.txt"
       slurp
       part-1)
  ;; => 1145

  (->> "input/day-1.txt"
       slurp
       part-2)
  ;; => 6561

  nil)
