(ns aoc2025.day-2
  (:require [clojure.string :as str]))

(defn invalid? [id]
  (let [s-id (str id)
        length (count s-id)
        half (int (/ length 2))
        p1 (take half s-id)
        p2 (take-last half s-id)]
    (cond
      (odd? length) false
      :else (= p1 p2))))

(defn part-1 [input]
  (->
    input
    str/trim
    (str/split #",")
    (->>
      (mapcat
        (fn [r]
          (let [[s e] (str/split r #"-")]
            (range (parse-long s) (inc (parse-long e))))))
      (filter invalid?)
      (reduce + 0))))

(defn invalid-2? [id]
  (let [s-id (str id)
        length (count s-id)
        half (int (/ length 2))]
    (some identity
      (for [s (range 1 (inc half))]
        (apply = (partition-all s s-id))))))

(defn part-2 [input]
  (->
    input
    str/trim
    (str/split #",")
    (->>
      (mapcat
        (fn [r]
          (let [[s e] (str/split r #"-")]
            (range (parse-long s) (inc (parse-long e))))))
      (filter invalid-2?)
      (reduce + 0))))

(comment

  (-> "input/day-2.txt"
    slurp
    part-1)
  ;; => 18595663903

  (-> "input/day-2.txt"
    slurp
    part-2)
  ;; => 19058204438

  nil)
