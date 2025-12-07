(ns aoc2025.day-4-test
  (:require [aoc2025.day-4 :as sut]
            [clojure.test :as t]))

(def input "
..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.
")

(t/deftest test-all-around
  (t/is (= [[\@ 1 1] [\. 2 0]]
           (sut/all-around
            [[\@ 1 1]
             [\. 2 0]
             [\@ 6 3]]
            2 1))))

(t/deftest test-part-1
  (t/is (= 13 (sut/part-1 input))))

