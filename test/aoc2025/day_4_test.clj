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
            2 1)))
  (t/is (= [[\@ 1 0]
            [\@ 1 1]
            [\@ 1 2]
            [\@ 2 0]
            [\@ 2 2]
            [\@ 3 0]
            [\@ 3 1]
            [\@ 3 2]]
          (sut/all-around
            [[\@ 1 0]
             [\@ 1 1]
             [\@ 1 2]
             [\@ 2 0]
             [\@ 2 1]
             [\@ 2 2]
             [\@ 3 0]
             [\@ 3 1]
             [\@ 3 2]]
            2 1)))
  (t/is (= []
           (sut/all-around
             [[\@ 0 0]
              [\@ 0 1]
              [\@ 0 2]
              [\@ 2 3]
              [\@ 4 0]
              [\@ 4 1]
              [\@ 4 2]]
            2 1))))

(t/deftest test-part-1
  (t/is (= 13 (sut/part-1 input))))

(t/deftest test-part-2
  (t/is (= 43 (sut/part-2 input))))
