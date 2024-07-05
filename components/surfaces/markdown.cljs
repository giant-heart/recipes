(ns components.surfaces.markdown
  (:require ["ink" :refer [render Text Box]]
            [components.surfaces.structure :as structure]
            [components.inputs.multi-line :as mli]
            [components.displays.markdown :as mkd]
            [components.utils :as util]
            [clojure.string :as s]))

(defn strikethrough-last-word [text]
  (let [words (s/split text #" ")
        last-word (last words)
        st-last-word (str "~" last-word "~")]
    (s/join " " (assoc words (dec (count words)) st-last-word))))

(defn find-closing-word [words]
  (first (util/positions (fn [w] (s/ends-with? w "~"))
                    words)))

(defn markdown-backspace [text]
  (if (not (s/ends-with? text "~"))
    (strikethrough-last-word text)
    (let [reversed-text (s/reverse text)
          words (s/split reversed-text #" ")
          pos-of-closing-word (find-closing-word words)]
      (if (= pos-of-closing-word (dec (count words)))
        text
        (let [closing-word (nth words pos-of-closing-word)
              closing-word-without-tilde (s/join "" (drop-last closing-word))
              words-without-close (assoc words
                                         pos-of-closing-word
                                         closing-word-without-tilde)
              next-word (nth words (inc pos-of-closing-word))
              next-word-with-tilde (str next-word "~")
              words-with-close (assoc words-without-close
                                      (inc pos-of-closing-word)
                                      next-word-with-tilde)]
          (s/reverse (s/join " " words-with-close)))))))


(defn markdown-input [entry* uid]
  (mli/multi-line-text-input entry* uid markdown-backspace))

(defn markdown-surface [entry* uid title]
  (structure/surface title
                     entry*
                     uid
                     markdown-input
                     mkd/markdown-display))
