(ns components.entry-composition
  (:require [components.renders.writing-surfaces.interface :as ws]
            [components.time :as time]
            [components.ui :as ui]))

(def render-functions {"plain" ws/plain-surface})

(defn create-entry [author-name]
  {:creation-date (time/todays-date)
   :surfaces []
   :author author-name})

(defn add-surface [entry* surface-type]
  (print "adding surface " surface-type)
  (let [new-surface {:type surface-type
                     :uid (str (random-uuid))
                     :render-function (get render-functions surface-type)
                     :contents nil}
        updated-surfaces (conj (vec (get @entry* :surfaces)) new-surface)]
    (print (map :uid updated-surfaces))
    (swap! entry* assoc :surfaces updated-surfaces)
    (ui/switch-focus (:uid new-surface))))
