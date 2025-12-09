(ns aoc2025.day-6
  (:require [clojure.string :as str]))

(defn calc [[operator & operands]]
  (apply ({ "+" + "*" *} operator) (map parse-long operands)))

(defn part-1 [input]
  (->>
    input
    str/trim
    str/split-lines
    (map
      (fn [s]
        (->
          s
          str/trim
          (str/split #" +"))))
    (apply map list)
    (map (fn [c]
           (->>
             c
             reverse
             calc)))
    (reduce + 0)))

(defn part-2 [input]
  (->>
    input
    str/trim
    str/split-lines
    (map
      (fn [s]
        (->
          s
          str/trim
          (str/split #" +"))))
    (apply map list)
    (map (fn [c]
           (->>
             c
             reverse
             calc)))
    (reduce + 0)))

(comment

  (-> "input/day-6.txt"
    slurp
    part-1
    )
  ;; => 4580995422905

  nil)
