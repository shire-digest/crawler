(ns shire-digest.crawler.utils
  "Utilities.")


(defn grab-content
  "Grab and memoize url's content."
  [url]
  (memoize (fn [] (slurp url))))
