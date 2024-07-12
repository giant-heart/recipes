(ns components.time
  (:require [clojure.string :as s]
            ["date-and-time$default" :as date]))

;; Handy date and time functions.
;; Every project needs em.

(def suffix-map {"1" "st"
                 "2" "nd"
                 "3" "rd"
                 "21" "st"
                 "22" "nd"
                 "23" "rd"
                 "31" "st"})

(defn day-suffix [day-of-month]
  (get suffix-map (str day-of-month) "th"))

(defn pretty-date
  "given an instant, returns a formatted date
  it looks like `Fri, Jul 12 2024`"
  [instant]
  (.format date instant "ddd, MMM DD YYYY"))

(defn ctime
  "given an instant, creates a time string useful for org-roam
  it looks like `20240712090722`"
  [instant]
  (.format date instant "YYYYMMDDHHMMSS"))

(defn todays-date []
  (pretty-date (new js/Date)))

(defn current-ctime []
  (ctime (new js/Date)))

(defn time-ago
  "calculates how much time has passed since a reference time
  in **milliseconds**"
  [reference-time]
  (- (.now js/Date)
     reference-time))
