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
   [aoc2025.core :as core]))


(deftest application-test
  (testing "TODO: Start with a failing test, make it pass, then refactor"

    ;; TODO: fix greet function to pass test
    (is (= "aoc2025 application developed by the secret engineering team"
           (core/greet)))

    ;; TODO: fix test by calling greet with {:team-name "Practicalli Engineering"}
    (is (= (core/greet "Practicalli Engineering")
           "aoc2025 service developed by the Practicalli Engineering team"))))
