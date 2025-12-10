(ns aoc2025.day-6-test
  (:require [aoc2025.day-6 :as sut]
            [clojure.test :as t]))

(def input "
123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   +  
")

(t/deftest test-calc
  (t/is (= 33210 (sut/calc ["*" "6" "45" "123"]))))

(t/deftest test-part-1
  (t/is (= 4277556 (sut/part-1 input))))

(t/deftest test-part-2
  (t/is (= 3263827 (sut/part-2 input))))
