(ns bases.ink
  (:require [components.renders.app :as a]
            [components.user-data :as user]
            [components.writing-recipes :as wr]
            [components.entry-composition :as ec]
            [clojure.string :as s]
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

(defn init-writing-recipes! []
  (reset! state/writing-recipes* (wr/get-recipes)))

(defn init-editor! []
  (let [init-recipe-name (if (seq *command-line-args*) (s/join " " *command-line-args*)
                             "Journal")]
    (ec/start-recipe! init-recipe-name)))

(defn init-app []
  (sh/exec "clear")
  (init-user-data!)
  (init-writing-recipes!)
  (init-editor!))

(init-app)

(render (r/as-element [(a/app :editor)]))
