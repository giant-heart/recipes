(ns bases.ink
  (:require
   ["ink" :refer [render Text Box]]
   [components.state :as state]
   [components.entry-composition :as ec]
   [components.renders.editor :as e]
   [reagent.core :as r]
   [babashka.cli :as cli]))



(print "hello")

(render (r/as-element [(e/writing-area)]))
