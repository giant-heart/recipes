(ns components.user-data
  (:require [components.time :as t]
            [clojure.string :as s]
            [components.state :as state]
            [components.storage.local-files :as lf]
            [clojure.edn :as edn]))

(defn get-profile []
  (let [read-profile (lf/read-from-file (str state/user-data-path "profile.edn"))
        parsed-profile (edn/read-string read-profile)]
    parsed-profile))

(defn count-of-recent-characters [save-log time-window]
  (let [time-cutoff (t/time-ago time-window)
        recent-entries (filter (fn [e]
                                 (< time-cutoff (second e)))
                               save-log)]
    (apply + (map first recent-entries))))

(defn update-save-log! [num-characters]
  (let [old-save-log (:save-log @state/user-data*)
        updated-log (conj old-save-log
                          [num-characters (.now js/Date)])]
    (swap! state/user-data* assoc :save-log updated-log)
    (lf/save-to-file (str @state/user-data*) (str state/user-data-path "profile.edn"))))
