(ns components.state
  (:require [reagent.core :as r]))

(defonce active-entry* (r/atom nil))

(defonce user-data* (r/atom nil))

(defonce characters-within-24-hrs* (r/atom 0))

(def default-book-end "🌟")

(def max-characters-per-24-hrs 1111)

(def org-storage-path "/home/wildflower/Documents/Research/FirstDrafts/")

(def user-data-path "/home/wildflower/.ghp/")

(defonce focus (r/atom "command-palette"))

(def default-tags nil)
