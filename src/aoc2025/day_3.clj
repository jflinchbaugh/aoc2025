(ns aoc2025.day-3
  (:require [clojure.string :as str]
            [clojure.math.combinatorics :as combo]))

(defn ordered-combos
  "produce all combinations but retain duplicate values,
  unlike combinatorics/combinations"
  [lst c]
  (->
    (map (fn [i v] [i v]) (range) lst)
    (combo/combinations 2)
    (->> (map (fn [[[_ a] [_ b]]] [a b])))))

(defn find-max [digits]
  (->>
    (ordered-combos digits 2)
    (map (fn [c] (parse-long (apply str c))))
    sort
    reverse
    first
    ))

(defn part-1 [input]
  (->> input
    str/split-lines
    (map find-max)
    (reduce + 0)))

(comment
  (->
    "input/day-3.txt"
    slurp
    part-1)
  ;; => 17100

  nil)
