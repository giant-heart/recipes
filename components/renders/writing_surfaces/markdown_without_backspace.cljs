(ns components.renders.writing-surfaces.markdown-without-backspace
  (:require ["ink" :refer [render Text Box Newline]]
            ["ink-text-input$default" :as TextInput]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]
            [components.renders.writing-surfaces.plain :as plain]
            [components.renders.writing-surfaces.multi-line-without-backspace :as ml]
            ["ink-markdown$default" :as Markdown]
            ["dedent$default" :as dedent]))

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
                     (:value c)]]
                   )
                 contents)))

(defn markdown-surface [entry* uid]
  (plain/surface entry*
                 uid
                 ml/multi-line-text-input-without-backspace
                 markdown-display))
