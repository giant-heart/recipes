(ns bases.ink
  (:require [components.renders.editor :as e]
            [components.user-data :as user]
            [components.entry-composition :as ec]
            ["ink" :refer [render]]
            [reagent.core :as r]
            [components.state :as state]))

(defn init []
  (reset! state/active-entry* (ec/entry "Poem" ""))

  (let [user-data (user/get-profile)
        seconds-in-a-day 8640000]
    (reset! state/user-data* user-data)
    (reset! state/characters-within-24-hrs* (user/count-of-recent-characters (:save-log user-data) seconds-in-a-day)
            (print (user/count-of-recent-characters (:save-log user-data) seconds-in-a-day))))

  (let [init-surface-type (first *command-line-args*)]
    (if init-surface-type
      (ec/add-surface! state/active-entry* init-surface-type)
      (ec/add-surface! state/active-entry* "plain"))))

(init)

(render (r/as-element [e/writing-area]))
