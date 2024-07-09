(ns components.user-data
  (:require [components.time :as t]
            [clojure.string :as s]
            [components.state :as state]
            [components.storage.local-files :as lf]
            [clojure.edn :as edn]))

(defn get-profile []
  (let [read-profile (lf/read-from-file (str state/user-data-path "profile.edn"))
        parsed-profile (edn/read-string read-profile)]
    (print parsed-profile)
    parsed-profile))

(defn count-of-recent-characters [save-log time-window]
  (let [time-cutoff (t/time-ago time-window)
        recent-entries (filter (fn [e]
                                 (< time-cutoff (js/parseInt (second e))))
                               save-log)]
    (print "recent-entries were " recent-entries)
    (apply + (map first recent-entries))))
