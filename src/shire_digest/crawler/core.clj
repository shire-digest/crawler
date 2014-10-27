(ns shire-digest.crawler.core
  "Crawler protocol.")

(defprotocol Crawler
  "Post crawler protocol.
  Each crawler should eat a link then return list of post metas."

  (parse [this link] "Parse a link."))
