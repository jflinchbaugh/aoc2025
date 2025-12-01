;; ---------------------------------------------------------
;; aoc2025.core
;; ---------------------------------------------------------

(ns aoc2025.core
  (:gen-class)
  (:require
   [com.brunobonacci.mulog :as log]))

;; ---------------------------------------------------------
;; Application

(defn -main
  "Entry point into the application via clojure.main -M"
  [& args]
  (let [team (first args)]
    (log/set-global-context!
     {:app-name "aoc2025 core" :version  "0.1.0-SNAPSHOT"})
    (log/log ::application-startup :arguments args)
    (if team
      (println "hello")
      (println (str "hello " team)))))

;; ---------------------------------------------------------


(comment

  nil)
