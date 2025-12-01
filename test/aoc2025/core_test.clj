;; ---------------------------------------------------------
;; aoc2025.core.-test
;;
;; Example unit tests for aoc2025.core
;;
;; - `deftest` - test a specific function
;; - `testing` logically group assertions within a function test
;; - `is` assertion:  expected value then function call
;; ---------------------------------------------------------


(ns aoc2025.core-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [aoc2025.core :as sut]))

(deftest application-test
  (testing "test"
    (is (= 1 1) "yay, math")))
