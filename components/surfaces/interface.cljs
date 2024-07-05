(ns components.surfaces.interface
  (:require [components.surfaces.single-line :as sl]
            [components.surfaces.multi-line :as ml]
            [components.surfaces.markdown :as mkd]))

(defn single-line-surface [entry* uid title]
  (sl/single-line-surface entry* uid title))

(defn multi-line-surface [entry* uid title]
  (ml/multi-line-surface entry* uid title))

(defn markdown-surface [entry* uid title]
  (mkd/markdown-surface entry* uid title))
