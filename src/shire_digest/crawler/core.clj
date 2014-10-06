(ns shire-digest.crawler.core
  "Crawler protocol.")

(defprotocol Crawler
  "Post crawler protocol.
  Each crawler should eat a link then return some post metas."

  (parse [this link] "Parse a link."))
