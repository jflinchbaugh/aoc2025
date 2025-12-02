;; ---------------------------------------------------------
;; aoc2025.core
;; ---------------------------------------------------------

(ns aoc2025.core
  (:gen-class)
  (:require
   [com.brunobonacci.mulog :as mu]))

;; ---------------------------------------------------------
;; Application

(defn -main
  "Entry point into the application via clojure.main -M"
  [& args]
  (let [team (first args)]
    #_(mu/start-publisher! {:type :console})
    (mu/set-global-context!
      {:app-name "aoc2025 core" :version  "0.1.0-SNAPSHOT"})
    (mu/log ::application-startup :arguments args)
    (if team
      (println "hello")
      (println (str "hello " team)))))

;; ---------------------------------------------------------


(comment

  (-main)

  nil)
