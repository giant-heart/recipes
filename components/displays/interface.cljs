(ns components.displays.interface
  (:require [components.displays.markdown :as mkd]
            [components.displays.multi-line :as ml]))

(defn multi-line-text-display [entry* uid]
  (ml/multi-line-text-display entry* uid))

(defn multi-line-print [contents]
  (ml/multi-line-print contents))

(defn markdown-display [entry* uid]
  (mkd/markdown-display entry* uid))

(defn markdown-print [contents]
  (mkd/markdown-print contents))
