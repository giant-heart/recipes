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

;; This is the entrypoint into our application when rendering to a terminal
;; using the ink library.

(defn init-user-data! []
  (let [user-data (user/get-profile)
        save-log (user/get-save-log)
        milliseconds-in-a-day 86400000
        {:keys [default-storage org-storage-path markdown-storage-path]} user-data]
    (reset! state/user-data* user-data)
    (reset! state/save-log* save-log)
    (reset! state/characters-within-24-hrs*
            (user/count-of-recent-characters save-log milliseconds-in-a-day))

    (if default-storage
      (reset! state/default-storage* default-storage))

    (if org-storage-path
      (reset! state/org-storage-path* org-storage-path))

    (if markdown-storage-path
      (reset! state/markdown-storage-path* markdown-storage-path))))

(defn init-writing-recipes! []
  (reset! state/writing-recipes* (wr/get-recipes)))

(defn init-editor! []
  (let [init-recipe-name (if (seq *command-line-args*) (s/join " " *command-line-args*)
                             nil)]
    (ec/init-blank-entry!)
    (if init-recipe-name
      (ec/start-recipe! init-recipe-name))))

(defn init-app []
  (sh/exec "clear")
  (init-user-data!)
  (init-writing-recipes!)
  (init-editor!))

(init-app)

(render (r/as-element [a/app state/active-screen*]))
