(ns shire-digest.crawler.utils
  "Utilities.")


(defn grab-content
  "Grab and memoize url's content."
  [url]
  (memoize (fn [] (slurp url))))


(defn grab-url-as-resource
  "Grab and memoize url's content as java.net.URL"
  [url]
  (memoize (fn [] (java.net.URL. url))))
