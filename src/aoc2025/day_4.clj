(ns aoc2025.day-4
  (:require [aoc2025.core :refer :all]
            [clojure.string :as str]
            [com.brunobonacci.mulog :as mu]))

(defn all-around [grid x y]
  (->>
   (for [dx (all-range -1 1)
         dy (all-range -1 1)
         :when (not= 0 dx dy)]
     (first (filter (fn [[_ x' y']] (= [(+ x dx) (+ y dy)] [x' y'])) grid)))
   (filter identity)))

(defn part-1 [input]
  (let [occupied (->>
                  input
                  parse-grid
                  (filter (fn [[p _ _]] (#{\@} p))))]
    (->>
     occupied
     (pmap
      (fn
        [[s x' y']]
        (> 4 (count (all-around occupied x' y')))))
     (filter identity)
     count)))

(defn part-1 [input]
  (let [occupied (->>
                  input
                  parse-grid
                  (filter (fn [[p _ _]] (#{\@} p))))]
    (->>
     occupied
     (pmap
      (fn
        [[s x' y']]
        (> 4 (count (all-around occupied x' y')))))
     (filter identity)
     count)))

(defn part-2 [input]
  (let [occupied (->>
                  input
                  parse-grid
                  (filter (fn [[p _ _]] (#{\@} p))))
        orig-count (count occupied)
        final-grid (loop [grid occupied]
                     (let [new-grid (->>
                                     grid
                                     (pmap
                                      (fn
                                        [[s x' y' :as spot]]
                                        [spot
                                         (> 4 (count (all-around grid x' y')))]))
                                     (remove second)
                                     (map first))
                           _ (mu/log ::loop
                                     :grid-count (count grid)
                                     :new-grid-count (count new-grid))]
                       (if (= (count new-grid) (count grid))
                         new-grid
                         (recur new-grid))))]
    (- orig-count (count final-grid))))

(comment
  (->
   "input/day-4.txt"
   slurp
   str/trim
   part-1)
  ;; => 1564

  (->
   "input/day-4.txt"
   slurp
   str/trim
   part-2)
  ;; => 9401

  nil)
