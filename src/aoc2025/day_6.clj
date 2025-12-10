(ns aoc2025.day-6
  (:require [clojure.string :as str]
            [com.brunobonacci.mulog :as mu]))

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

(defn recompose [i]
  (mu/log ::recompose :i i)
  (let [operator (str (last (first i)))
        operands (map (fn [i'] (->> i'
                                 (filter (complement #{\* \+ \space}))
                                 str/join)) i)]
    (cons operator operands)))

(defn part-2 [input]
  (->>
    input
    str/split-lines
    (remove str/blank?)
    (apply map list)
    (partition-by (partial every? #{\space}))
    (remove (fn [c] (every? #{\space} (first c))))
    (map recompose)
    (map calc)
    (reduce + 0)
    ))

(comment

  (-> "input/day-6.txt"
    slurp
    part-1
    )
  ;; => 4580995422905

  (-> "input/day-6.txt"
    slurp
    part-2
    )
  ;; => 10875057285868

  nil)
