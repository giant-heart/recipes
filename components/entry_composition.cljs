(ns components.entry-composition
  (:require [components.surfaces.interface :as surfaces]
            [components.time :as time]
            [components.ui :as ui]))

(def render-functions {"plain" surfaces/single-line-surface
                       "multi-line" surfaces/multi-line-surface
                       "markdown" surfaces/markdown-surface})

(defn entry [author-name]
  {:creation-date (time/todays-date)
   :surfaces []
   :author author-name})

(defn add-surface! [entry* surface-type]
  (let [new-surface {:type surface-type
                     :uid (str (random-uuid))
                     :render-function (get render-functions surface-type)
                     :contents nil}
        updated-surfaces (conj (vec (get @entry* :surfaces)) new-surface)]
    (swap! entry* assoc :surfaces updated-surfaces)
    (ui/switch-focus (:uid new-surface))))
