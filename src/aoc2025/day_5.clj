(ns aoc2025.day-5
  (:require [aoc2025.core :refer :all]
            [clojure.string :as str]))

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
        (fn [i] (some (fn [[start end]] (<= start i end)) fresh-checks))
        )
      count)))

(comment
  (->>
   "input/day-5.txt"
   slurp
   part-1)
  ;; => 674

  )
