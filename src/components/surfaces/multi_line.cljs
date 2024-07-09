(ns components.surfaces.multi-line
  (:require ["ink" :refer [render Text Box]]
            [components.surfaces.structure :as structure]
            [components.inputs.multi-line :as mli]
            [components.displays.multi-line :as mld]))

(defn multi-line-surface [entry* uid title]
  (structure/surface title
                     entry*
                     uid
                     mli/multi-line-text-input
                     mld/multi-line-text-display))
