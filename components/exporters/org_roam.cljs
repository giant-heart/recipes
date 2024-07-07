(ns components.exporters.org-roam
  (:require [components.time :as t]
            [clojure.string :as s]))

(defn markdown->org [text]
  (s/replace text "~" "+"))

(defn org-tags [tags]
  (str "#+filetags: :"
       (s/join ":" tags)
       "\n"))

(defn file-name [title ctime]
  (let [formatted-title (s/replace title " " "_")]
    (str ctime "-" formatted-title ".org")))

(defn metadata [title ctime & tags]
  (str ":PROPERTIES:\n"
       ":ID:\t" (random-uuid) "\n"
       ":ctime:\t" ctime "\n"
       ":END:\n"
       "#+title: " title "\n"
       (if tags (org-tags (first tags)) nil)))
