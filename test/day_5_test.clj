(ns day-5-test
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
