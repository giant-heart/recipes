(ns components.utils)

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
