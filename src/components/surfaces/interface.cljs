(ns components.surfaces.interface
  (:require [components.surfaces.single-line :as sl]
            [components.surfaces.multi-line :as ml]
            [components.surfaces.poem :as pi]
            [components.surfaces.markdown :as mkd]))

;; The interface file for all our surfaces
;; It's handy so that we don't have to reference/update
;; 4 different namespaces when we want to use surfaces
;; we can just reference this interface.

(defn single-line-surface [entry* uid title]
  (sl/single-line-surface entry* uid title))

(defn multi-line-surface [entry* uid title]
  (ml/multi-line-surface entry* uid title))

(defn poem-surface [entry* uid title]
  (pi/poem-surface entry* uid title))

(defn markdown-surface [entry* uid title]
  (mkd/markdown-surface entry* uid title))
