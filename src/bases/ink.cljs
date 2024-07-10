(ns bases.ink
  (:require [components.renders.editor :as e]
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

    (reset! state/active-recipe* (wr/get-recipe-by-name init-recipe-name))
    (reset! state/active-entry* (ec/entry-from-recipe init-recipe-name))

    (ec/add-next-surface-in-recipe! state/active-entry*
                                    state/active-recipe*
                                    state/active-recipe-position*)))

(defn init-app []
  (sh/exec "clear")
  (init-user-data!)
  (init-writing-recipes!)
  (init-editor!))

(init-app)

(render (r/as-element [e/writing-area]))
