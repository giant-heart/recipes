(ns components.user-data
  (:require [components.time :as t]
            [clojure.string :as s]
            [components.state :as state]
            [components.storage.local-files :as lf]
            [clojure.edn :as edn]))

;; These functions allow us to read user data
;; and calculate certain meta attributes such as the count of recent-characters.

(defn get-profile
  "Reads the user profile from disk based on the user-data-path defined"
  []
  (let [read-profile (lf/read-from-file (str state/user-data-path "profile.edn"))
        parsed-profile (edn/read-string read-profile)]
    parsed-profile))

(defn get-save-log
  "Reads the user save-log from disk based ont he user-data-path defined"
  []
  (let [read-save-log (lf/read-from-file (str state/user-data-path "save_log.edn"))
        parsed-save-log (edn/read-string read-save-log)]
    parsed-save-log))

(defn count-of-recent-characters
  "Calculates the number of characters saved given the save-log and
  the amount of milliseconds that we consider to be recent."
  [save-log time-window]
  (let [time-cutoff (t/time-ago time-window)
        recent-entries (filter (fn [e]
                                 (< time-cutoff (second e)))
                               save-log)]
    (apply + (map first recent-entries))))

(defn update-save-log!
  "Updates the save-log with the most recent number of characters saved.
  The save-log is a vector of vectors that looks like:
  [[<num-characters> <time-recorded>] [<num-characters> <time-recorded>]]"
  [num-characters]
  (let [old-save-log (:save-log @state/user-data*)
        updated-log (conj old-save-log
                          [num-characters (.now js/Date)])]
    (reset! state/save-log* updated-log)
    (lf/save-to-file (str @state/save-log*) (str state/user-data-path "save_log.edn"))))
