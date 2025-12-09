(ns aoc2025.day-5-test
  (:require  [clojure.test :as t]
             [aoc2025.day-5 :as sut]))

(def input "
3-5
10-14
16-20
12-18

1
5
8
11
17
32
")

(t/deftest test-part-1
  (t/is (= 3 (sut/part-1 input))))

(t/deftest test-merge-ranges
  (t/are
   [expected r1 r2]
   (= expected (sut/merge-ranges r1 r2))
    [[1 2] [4 5]] [1 2] [4 5] ; non-intersecting
    [[1 6]] [1 3] [3 6] ; overlapping end merges
    [[1 6]] [1 6] [2 3] ; first contains second
    [[1 6]] [1 6] [5 6] ; first contains second at end
    [[1 6]] [1 3] [2 6] ; merge: start first, end second
    [[1 6]] [2 6] [1 5] ; merge: start second, end first
    ))

(t/deftest test-merge-all-ranges
  (t/are
   [expected a r]
   (= expected (sut/merge-all-ranges a r))
   [[1 2]] [] [1 2]
   [[1 4]] [[1 4]] [2 3]
   [[6 7] [1 4]] [[1 4]] [6 7]))

(t/deftest test-part2
  (t/is (= 14 (sut/part-2 input))))
