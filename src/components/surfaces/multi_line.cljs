(ns components.surfaces.multi-line
  (:require ["ink" :refer [render Text Box]]
            [components.surfaces.structure :as structure]
            [components.inputs.multi-line :as mli]
            [components.displays.multi-line :as mld]))

;; A simple surface, it has a title, entry, uid
;; and then includes an input component, and a display component.
;; other surfaces can have other combinations of components,
;; and even modify these components just as long as they accept and return
;; similar values.

(defn multi-line-surface [entry* uid title]
  (structure/surface title
                     entry*
                     uid
                     mli/multi-line-text-input
                     mld/multi-line-text-display))
