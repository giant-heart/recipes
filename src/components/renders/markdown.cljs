(ns components.renders.markdown
  (:require ["ink" :refer [render Text Box Newline]]
            ["ink-text-input$default" :as TextInput]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]
            [components.renders.writing-surfaces.plain :as plain]
            [components.renders.writing-surfaces.multi-line :as ml]
            ["ink-markdown$default" :as Markdown]))

;; This renders markdown for view in a surface
;; It expects for the contents to be a vector of lines
;; example: [{:text "# Our first line"} {:text "a *second* line"}]

(defn markdown-display [entry* uid]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)]
    (map-indexed (fn [idx c]
                   [:> Box
                    {:flex-direction "column"
                     :key (str uid "-mkd-" idx)}
                    [:> Markdown
                     {:width 80
                      :reflow-text true}
                     (:text c)]]
                   )
                 contents)))
