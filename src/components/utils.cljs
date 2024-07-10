(ns components.utils
  (:require [clojure.string :as s]))

(defn positions
  [pred coll]
  (keep-indexed (fn [idx x]
                  (when (pred x)
                    idx))
                coll))

(defn position-of-surface [uid surfaces]
  (first (positions (fn [s]
                      (= (:uid s) uid))
                    surfaces)))

(defn update-surface-contents! [entry* surface-uid new-contents]
  (let [updated-surfaces (map (fn [s]
                                (if (= surface-uid (:uid s))
                                  (assoc s :contents new-contents) s))
                              (:surfaces @entry*))]
    (swap! entry* assoc :surfaces updated-surfaces)))


(defn insert-at-index [v i e]
  (vec (concat (take i v) [e] (drop i v))))