(ns aoc2025.day-4
  (:require [aoc2025.core :refer :all]
            [clojure.string :as str]))

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

(comment
  (-> "input/day-4.txt"
    slurp
    str/trim
    part-1)
  ;; => 1564


  nil)
