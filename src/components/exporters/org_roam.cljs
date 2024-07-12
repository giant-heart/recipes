(ns components.exporters.org-roam
  (:require [components.time :as t]
            [clojure.string :as s]
            [components.state :as state]
            [components.storage.local-files :as lf]))

;; Here is where we save entries to disk.
;; In this case we're exporting a string of markdown text
;; to be stored as part of an org-roam library
;; a similar exporter could be written to export to Obsidian or Logseq for example.

(defn markdown->org
  "a hilariously minimal conversion that only changes the strikethrough characters"
  [text]
  (s/replace text "~" "+"))

(defn org-tags
  "creates the string that would represent tags in org-roam to be added
  to the generated header"
  [tags]
  (if (seq tags)
    (str "#+filetags: :"
         (s/join ":" tags)
         ": \n")
    nil))

(defn file-name
  "creates a properly formatted file-name which includes the current time
  and a title that escapes spaces to be underscores"
  [title ctime]
  (let [formatted-title (s/replace title " " "_")]
    (str ctime "-" formatted-title ".org")))

(defn metadata
  "creates the metadata block to add to the top of the file"
  [title ctime & tags]
  (str ":PROPERTIES:\n"
       ":ID:\t" (random-uuid) "\n"
       ":ctime:\t" ctime "\n"
       ":END:\n"
       "#+title: " title "\n"
       (first tags)))

(defn export-markdown->org-roam
  "exports a markdown text to a format we can save with org-roam"
  [text title ctime & tags]
  (let [tags (if (first tags)
               (org-tags (first tags))
               nil)
        org-text (markdown->org text)]
    (str (metadata title ctime tags)
         org-text)))

(defn save-org-locally
  "Given a text and a title, convert it to a form compatible with org-roam
  and save it to disk."
  [text title]
  (let [ctime (t/current-ctime)
        file-path (str @state/org-storage-path* (file-name title ctime))
        converted-text (export-markdown->org-roam text title ctime state/default-tags)]
    (lf/save-to-file converted-text file-path)))
