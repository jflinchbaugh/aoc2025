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

(t/deftest test-part-1
  (t/is (= 3 (sut/part-1 input))))

(t/deftest test-rotate-2
  (t/are
      [expected start turn]
      (= expected (sut/rotate-2 start turn))
    [5 - 0] [5 + 0] "R0"
    [5 + 0] [5 + 0] "L0"
    [6 + 1] [5 + 0] "L1"
    [4 - 1] [5 + 0] "R1"
    [99 - 2] [1 + 0] "R2"
    [1 + 2] [99 + 0] "L2"))

(t/deftest test-times-passed-0
  (t/are
      [expected in]
      (= expected (sut/times-passed-0 in))
    ; [current op clicks]
    0 [50 + 0]
    0 [1 - 98]
    0 [99 + 99]
    1 [0 - 1]
    1 [0 + 1]
    2 [0 - 100]
    2 [0 + 100]
    2 [0 - 199]
    2 [0 + 199]
    3 [0 - 200]
    3 [0 + 200]
    1 [1 + 2]
    1 [99 - 2]
    2 [1 + 102]
    2 [99 - 102]
    1 [50 + 99]
    1 [50 - 99]
    1 [50 + 100]
    1 [50 - 100]
    0 [86 - 14]
    0 [10 - 90]
    0 [99 + 99]))

(t/deftest test-part-2
  (t/is (= 6 (sut/part-2 input))))
