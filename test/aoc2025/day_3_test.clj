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
  (t/is (=
         [[10 20] [10 30] [10 10] [20 30] [20 10] [30 10]]
         (sut/ordered-combos [10 20 30 10] 2))))

(t/deftest test-find-max
  (t/are
   [expected input]
   (= expected (sut/find-max input))
   89 "89"
   89 "189"
   89 "819"
   82 "812"
   82 "2812"
   98 "8918"))

(t/deftest test-part-1
  (t/is (= 357 (sut/part-1 input))))
