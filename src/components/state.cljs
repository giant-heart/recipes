(ns components.state
  (:require [reagent.core :as r]))

(defonce active-entry* (r/atom nil))

(def default-book-end "🌟")

(def max-characters-per-24-hrs 1000)

(def org-storage-path "/home/wildflower/Documents/Research/FirstDrafts/")

(defonce focus (r/atom "command-palette"))

(defonce characters-within-24-hrs* (r/atom 0))

(def default-tags nil)
