(ns aoc2025.day-1-test
  (:require [aoc2025.day-1 :as sut]
            [clojure.test :as t]))

(def input "
L68
L30
R48
L5
R60
L55
L1
L99
R14
L82
")

(t/deftest test-part-1
  (t/is (= 3 (sut/part-1 input))))

(t/deftest test-rotate
  (t/are
      [expected start turn]
      (= expected (sut/rotate start turn))
    5 5 "R0"
    5 5 "L0"
    6 5 "L1"
    4 5 "R1"
    99 1 "R2"
    1 99 "L2"))
