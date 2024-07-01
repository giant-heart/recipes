(ns components.utils
  (:require [reagent.core :as r]))

(defonce focus (r/atom ""))

(defn switch-focus [target]
  (print "setting focus to be " target)
  (reset! focus target))
