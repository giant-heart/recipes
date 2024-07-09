(ns components.time
  (:require [clojure.string :as s]
            ["date-and-time$default" :as date]))

(def suffix-map {"1" "st"
                 "2" "nd"
                 "3" "rd"
                 "21" "st"
                 "22" "nd"
                 "23" "rd"
                 "31" "st"})

(defn day-suffix [day-of-month]
  (get suffix-map (str day-of-month) "th"))

(defn pretty-date [instant]
  (.format date instant "ddd, MMM DD YYYY"))

(defn ctime [instant]
  (.format date instant "YYYYMMDDHHMMSS"))

(defn todays-date []
  (pretty-date (new js/Date)))

(defn current-ctime []
  (ctime (new js/Date)))

(defn time-ago [reference-time]
  (- (.now js/Date)
     reference-time))
