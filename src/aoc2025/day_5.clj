(ns aoc2025.day-5
  (:require [aoc2025.core :refer :all]
            [clojure.string :as str]
            [com.brunobonacci.mulog :as mu]))

(defn part-1 [input]
  (let [[fresh _ ingredients] (->>
                               input
                               str->lines
                               (partition-by #{""}))
        fresh-checks (->>
                      fresh
                      (map
                       (fn [i]
                         (let [[start end] (str/split i #"-")]
                           (sort [(parse-long start) (parse-long end)])))))
        ingredients (map parse-long ingredients)]
    (->>
     ingredients
     (filter
      (fn [i] (some (fn [[start end]] (<= start i end)) fresh-checks)))
     count)))

(defn merge-ranges
  [[s1 e1 :as r1] [s2 e2 :as r2]]
  (cond
    (<= s1 s2 e2 e1) [r1]
    (<= s2 s1 e1 e2) [r2]
    (<= s1 s2 e1 e2) [[s1 e2]]
    (<= s2 s1 e2 e1) [[s2 e1]]
    :else [r1 r2]))

(defn merge-all-ranges [ranges r]
  (let [[current & done] ranges]
    (cond
      (nil? current) [r]
      :else (concat (reverse (merge-ranges current r)) done))))

(defn part-2 [input]
  (let [fresh (->>
               input
               str->lines
               (partition-by #{""})
               first)
        fresh-checks (->>
                      fresh
                      (map
                       (fn [i]
                         (let [[start end] (str/split i #"-")]
                           (vec (sort [(parse-long start) (parse-long end)])))))
                      sort)]
    (->>
      fresh-checks
      (reduce merge-all-ranges [])
      (map (fn [[s e]] (inc (- e s))))
      (reduce + 0))))

(comment
  (->>
   "input/day-5.txt"
   slurp
   part-1)
;; => 674


  (->>
    "input/day-5.txt"
    slurp
    part-2)
  ;; => 352509891817881

  )
