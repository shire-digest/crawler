(ns shire-digest.crawler.collections
  "Crawlers map."
  (:require [shire-digest.crawler.echo :refer [echo-crawler]]
            [shire-digest.crawler.wikipedia.en.tfa :as en-tfa]))


(def crawlers
  {:echo echo-crawler
   :en-wikipedia-tfa en-tfa/tfa-crawler})
