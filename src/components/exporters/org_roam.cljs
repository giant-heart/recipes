(ns components.exporters.org-roam
  (:require [components.time :as t]
            [clojure.string :as s]
            [components.state :as state]
            [components.storage.local-files :as lf]))

(defn markdown->org [text]
  (s/replace text "~" "+"))

(defn org-tags [tags]
  (print tags)
  (if (seq tags)
    (str "#+filetags: :"
         (s/join ":" tags)
         ": \n")
    nil))

(defn file-name [title ctime]
  (let [formatted-title (s/replace title " " "_")]
    (str ctime "-" formatted-title ".org")))

(defn metadata [title ctime & tags]
  (str ":PROPERTIES:\n"
       ":ID:\t" (random-uuid) "\n"
       ":ctime:\t" ctime "\n"
       ":END:\n"
       "#+title: " title "\n"
       (first tags)))

(defn export-markdown [text title ctime & tags]
  (let [tags (if (first tags)
               (org-tags (first tags))
               nil)
        org-text (markdown->org text)]
    (str (metadata title ctime tags)
         org-text)))

(defn save-org-locally [text title]
  (let [ctime (t/current-ctime)
        file-path (str state/org-storage-path (file-name title ctime))
        converted-text (export-markdown text title ctime state/default-tags)]
    (lf/save-to-file converted-text file-path)))
