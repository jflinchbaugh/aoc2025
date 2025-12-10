(ns aoc2025.day-7
  (:require [aoc2025.core :refer :all]))

(defn walk [[splits beams] row]
  (let [hits (->> row
               (filter (fn [[x y]] (beams x))))
        continuing-beams (->>
                           beams
                           (remove (set (map first row))))
        new-beams (->> hits
                    (mapcat (fn [[x y]] [(dec x) (inc x)])))]
    [(set (concat splits hits)) (set (concat continuing-beams new-beams))]))

(defn part-1 [input]
  (let [diagram (->>
                 input
                 parse-grid)
        start (->>
                diagram
                (filter (fn [[c x y]] (#{\S} c)))
                first
                rest)
        splitters (->>
                    diagram
                    (filter (fn [[c x y]] (#{\^} c)))
                    (map rest)
                    (partition-by second))]
    (->> splitters
      (reduce walk [[] #{(first start)}])
      first
      count)))

(comment
  (->
    "input/day-7.txt"
    slurp
    part-1)
  ;; => 1649


  nil)
