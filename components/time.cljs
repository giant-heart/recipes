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

(defn todays-date []
  (pretty-date (new js/Date)))
