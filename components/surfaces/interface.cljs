(ns components.surfaces.interface
  (:require [components.surfaces.single-line :as sl]
            [components.surfaces.multi-line :as ml]))

(defn single-line-surface [entry* uid title]
  (sl/single-line-surface entry* uid title))

(defn multi-line-surface [entry* uid title]
  (ml/multi-line-surface entry* uid title))
