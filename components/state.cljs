(ns components.state
  (:require [reagent.core :as r]))

(defonce active-entry* (r/atom nil))
(defonce focus (r/atom "command-palette"))
