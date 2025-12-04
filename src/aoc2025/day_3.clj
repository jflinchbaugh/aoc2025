(ns aoc2025.day-3
  (:require [clojure.string :as str]
            [clojure.math.combinatorics :as combo]
            [com.brunobonacci.mulog :as mu]))

(defn ordered-combos
  "produce all combinations but retain duplicate values,
  unlike combinatorics/combinations"
  [c lst]
  (if (not (seq lst))
    []
    (->
      (map list (range) lst) ; introduce indices to make every value unique
      (combo/combinations c)
      (->> (map (fn [lst] (map second lst)))))))

(defn pair-down-max
  "pair down a list of digits to produce n digits to make the largest number"
  ([n digits]
   (pair-down-max [] n digits))

  ([selected n digits]
  (if (<= n (count selected))
    selected
    (let [front (drop-last (- n (count selected) 1) digits)
          end (take-last (- n (count selected) 1) digits)
          largest (->> front (reduce max 0))]
      (recur
       (conj selected largest)
       n
       (concat
        (rest (drop-while (partial not= largest) front))
        end))))))

(defn find-max [n digits]
  (->>
   digits
   (map (comp parse-long str))
   (pair-down-max n)
   (apply str)
   parse-long))

(defn part-1 [input]
  (->> input
       str/split-lines
       (map (partial find-max 2))
       (reduce + 0)))

(defn part-2 [input]
  (->> input
       str/split-lines
       (map (partial find-max 12))
       (reduce + 0)))

(comment
  (->
   "input/day-3.txt"
   slurp
   part-1)
  ;; => 17100

  (->
   "input/day-3.txt"
   slurp
   part-2)
  ;; => 170418192256861

  nil)
