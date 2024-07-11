(ns components.renders.screens.help
  (:require [components.renders.header :as h]
            ["ink" :refer [render Text Box]]
            ["ink-markdown$default" :as Markdown]
            [components.renders.command-palette :as c]
            [components.entry-composition :as ec]
            [components.ui :as ui]
            [components.state :as state]
            [reagent.core :as r]))

(def help-text
  "# Welcome to Heart
A playground for writing

## Surfaces
You write on surfaces, and each surface can have a special meaning or purpose. For example, the `poem` block will display syllable counts to the left.
- Backspace is not allowed
- You cannot move the cursor.\n

## Guides
Heart is based around the included guides. These guides will take you through a series of steps to write an entry. For example, the `giant heart poem` guide takes you through the three steps of:
1. Inspiration - where you write what inspires you today
2. Poem - where you write a poem about the topic and,
3. Reflection - where you write about what the poem meant to you. \n

## Commands
- `Cmd+Space` or \"`\": switch focus to command panel
- `help` : show this menu
- `close` : hide this menu
- `add <surface>` : add a writing surface. Options are: `markdown`, `poem` and `multi-line`. It defaults to `markdown`
- `start <guide>` : clears the current entry and starts a guided flow. Options are: `giant heart poem`, `the work`, and `journal`. It defaults to `journal`
- `next` : moves to the next step in the current guide!
- `recycle`: clears the current entry
- `save`: exports your entry based on your configuration file
")


(defn help-area []
  (ui/switch-focus "command-palette")
  [:> Box
   {:flex-direction "column"
    :border-style "round"
    :background-color "teal"
    :padding-left 1
    :padding-right 1
    :width "100%"}
   (h/title-block state/active-entry* "tiny")
   [:> Markdown
    {:width "80%"
     :reflow-text true
     :gap 1}
    help-text]
   [:> Text (str @state/org-storage-path*)]
   (c/command-palette state/active-entry*)
   ])
