(ns shire-digest.crawler.collections
  "Crawlers map."
  (:require [shire-digest.crawler.echo :refer echo-crawler]))


(def crawlers
  {:echo echo-crawler})
