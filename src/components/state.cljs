(ns components.state
  (:require [reagent.core :as r]
            ["os" :refer [homedir]]))

;; State is stored in a series of atoms that are restricted to this namespace.

;; The user profile data. This includes their name and a savelog.
(defonce user-data* (r/atom nil))

;; Which text input to give focus to.
;; In this `inkjs` inputs need to be explicitly disabled when not in use
;; otherwise they will continue to receive input.
(defonce focus (r/atom "command-palette"))

;; This is the active screen
;; Currently the two screens are :help, and :editor
(defonce active-screen* (r/atom :help))

;; This refers to the currently active entry.
;; This stores the multiple writing surfaces which may or may not
;; be part of the active recipe.
(defonce active-entry* (r/atom nil))

;; These atoms concern our writing recipes
;; `writing-recipes*`: recipes that we read locally or from files
;; `active-recipe*` : the recipe being used for the current entry
;; `active-recipe-position` : an int representing the current position in recipe vector
(defonce writing-recipes* (r/atom []))
(defonce active-recipe* (r/atom nil))
(defonce active-recipe-position* (r/atom 0))

;; This refers to a calculated value of the number of characters written
;; in the last 24 hours. It is based  on reading the save-log in user-data
;; and updated when `save` is called
(defonce characters-within-24-hrs* (r/atom 0))

;; The maximum characters that we would allow
;; Only applicable if we place a character limit
(def max-characters-per-24-hrs 1111)

;; The icon to show as a cursor for writing surfaces
(def default-book-end "🌟")

;; The location to save documents to
(defonce org-storage-path* (r/atom "./"))

;; Default tags to add when saving
(def default-tags nil)

;; The path to get user data from
(def user-data-path (str (homedir) "/.heart/"))
