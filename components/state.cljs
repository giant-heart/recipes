(ns components.state
  (:require [reagent.core :as r]))

(defonce active-entry* (r/atom nil))

(def default-book-end "🌟")

(defonce focus (r/atom "command-palette"))
