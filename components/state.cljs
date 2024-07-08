(ns components.state
  (:require [reagent.core :as r]))

(defonce active-entry* (r/atom nil))

(def default-book-end "🌟")

(def org-storage-path "/home/wildflower/Documents/Research/FirstDrafts/")

(defonce focus (r/atom "command-palette"))
