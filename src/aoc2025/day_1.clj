(ns aoc2025.day-1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn rotate [start turn]
  (let [[_ d c] (re-find #"(\w)(\d+)" turn)
        dir-op ({"R" - "L" +} d)
        clicks (parse-long c)]
    (mod (dir-op start clicks) 100))
  )

(defn part-1 [input]
  (->>
    input
    str/trim
    str/split-lines
    (reductions rotate 50)
    (filter #{0})
    count)
  )

(comment

  (rest "R10")

  (re-find #"(\w)(\d+)" "R10")

  (mod -30 10)

  (->> "input/day-1.txt"
    slurp
    part-1)

  nil)
