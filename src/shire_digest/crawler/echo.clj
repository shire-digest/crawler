(ns shire-digest.crawler.echo
  "Echo crawler."
  (:require [shire-digest.meta.post :as post]
            [shire-digest.crawler.core :refer [Crawler parse]]))


(deftype EchoCrawler []
  Crawler
  (parse [this link]
    (list (post/make :link link :title link))))

(def echo-crawler (EchoCrawler.))
