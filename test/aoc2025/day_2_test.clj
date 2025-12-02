(ns aoc2025.day-2-test
  (:require  [clojure.test :as t]
             [aoc2025.day-2 :as sut]))

(def input "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")

(t/deftest test-invalid?
  (t/testing "invalid"
    (t/are
     [id]
     (sut/invalid? id)
      11
      22
      1010
      104104))
  (t/testing "valid"
    (t/are
     [id]
     (not (sut/invalid? id))
      10
      1
      111
      104105)))

(t/deftest part-1
  (t/is (= 1227775554 (sut/part-1 input))))

(t/deftest test-invalid-2?
  (t/testing "invalid"
    (t/are
     [id]
     (sut/invalid-2? id)
      11
      22
      1010
      104104
      111
      121212
      43214321
      432143214321))
  (t/testing "valid"
    (t/are
     [id]
     (not (sut/invalid-2? id))
      10
      1
      104105
      4321432143)))

(t/deftest part-2
  (t/is (= 4174379265 (sut/part-2 input))))
