(ns components.entry-composition
  (:require [components.surfaces.interface :as surfaces]
            [components.displays.interface :as d]
            [components.time :as t]
            [clojure.string :as s]
            [components.ui :as ui]))

(def render-functions {"plain" surfaces/single-line-surface
                       "multi-line" surfaces/multi-line-surface
                       "markdown" surfaces/markdown-surface
                       "poem" surfaces/poem-surface})

(def print-functions {"plain" (fn [e] e)
                      "multi-line" d/multi-line-print
                      "poem" d/multi-line-print
                      "markdown" d/markdown-print})

(defn entry [title author-name]
  {:title title
   :creation-date (t/todays-date)
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


(defn extract-contents-from-entry [entry*]
  (let [surfaces (:surfaces @entry*)
        contents (map (fn [s]
                        (let [{:keys [contents type]} s
                              print-func (get print-functions type)]
                          (print-func contents))) surfaces)]
    (s/join "\n \n" contents)))
