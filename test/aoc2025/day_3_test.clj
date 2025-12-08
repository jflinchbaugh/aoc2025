(ns aoc2025.day-3-test
  (:require [aoc2025.day-3 :as sut]
            [clojure.test :as t]
            [clojure.string :as str]))

(def input (str/trim "
987654321111111
811111111111119
234234234234278
818181911112111
"))

(t/deftest test-ordered-combos
  (t/are
   [expected n lst]
   (= expected (sut/ordered-combos n lst))
    [[10 20] [10 30] [10 10] [20 30] [20 10] [30 10]] 2 [10 20 30 10]
    [[10 20 30] [10 20 10] [10 30 10] [20 30 10]] 3 [10 20 30 10]))

(t/deftest test-find-max
  (t/are
   [expected n input]
   (= expected (sut/find-max n input))
    89 2 "89"
    89 2 "189"
    89 2 "819"
    82 2 "812"
    82 2 "2812"
    98 2 "8918"
    92 2 "818181911112111"
    918 3 "8911118"))

(t/deftest test-pair-down-max
  (t/are
   [expected n input]
      (=
        expected
        (parse-long
          (apply str
            (sut/pare-down-max n
              (map (comp parse-long str) input)))))
    89 2 "89"
    89 2 "189"
    89 2 "819"
    82 2 "812"
    82 2 "2812"
    98 2 "8918"
    92 2 "818181911112111"
    918 3 "8911118"))

(t/deftest test-part-1
  (t/is (= 357 (sut/part-1 input))))

(t/deftest test-part-2
  (t/is (= 3121910778619 (sut/part-2 input))))
