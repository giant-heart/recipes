(ns components.ui
  (:require [reagent.core :as r]))

(defonce focus (r/atom ""))

(defn switch-focus [target]
  (reset! focus target))
