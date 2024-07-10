(ns bases.ink
  (:require [components.renders.editor :as e]
            [components.user-data :as user]
            [components.entry-composition :as ec]
            ["ink" :refer [render]]
            ["shelljs$default" :as sh]
            [reagent.core :as r]
            [components.state :as state]))

(defn init-user-data! []
  (let [user-data (user/get-profile)
        milliseconds-in-a-day 86400000]
    (reset! state/user-data* user-data)
    (reset! state/characters-within-24-hrs*
            (user/count-of-recent-characters (:save-log user-data) milliseconds-in-a-day))))

(defn read-writing-forms [])

(defn init-editor! []
  (let [init-surface-type (first *command-line-args*)]
    (reset! state/active-entry* (ec/entry "giant heart poem" ""))
    (if init-surface-type
      (ec/add-surface! state/active-entry* init-surface-type)
      (ec/add-surface! state/active-entry* "plain"))))

(defn init []
  (sh/exec "clear")
  (init-user-data!)
  (init-editor!))

(init)

(render (r/as-element [e/writing-area]))
