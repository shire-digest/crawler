(ns shire-digest.crawler.wikipedia.en.tfa
  "Wikipedia today featured article crawler."
  (:require [clojure.string :as string]
            [shire-digest.meta.post :as post]
            [shire-digest.crawler.core :refer [Crawler parse]]
            [shire-digest.crawler.utils :refer [grab-content]]
            [shire-digest.meta.utils :refer [today]]
            [clj-xpath.core :refer [$x $x:text]]))

(def tfa-author "Wikipedia")
(def wikipedia-base-url "http://en.wikipedia.org")
(defn- wikipedia-page-url [item] (str wikipedia-base-url item))

(defn- extract-tfa-text
  "Extract tfa content."
  [page]
  (let [node-text ($x:text "//div[@id='mp-tfa']" page)
        content (last (re-find #"(?s)(.*)\(Full.*article\..*" node-text))]
    (if content
      (string/trim content)
      nil)))

(defn- extract-tfa-meta
  "Extract article meta."
  [page]
  (let [a-nodes ($x "//div[@id='mp-tfa']//a[1]" page)]
    (loop [cur-node (first a-nodes) nodes (rest a-nodes)]
      ; Skip figure node.
      (if (not= "image" (-> cur-node :attrs :class))
        {:link (wikipedia-page-url (-> cur-node :attrs :href)) :title (:text cur-node)}
        (recur (first nodes) (rest nodes))))))

(defn parse-tfa
  "Parse tfa from page content."
  [page]
  (let [page-meta (extract-tfa-meta page)
        page-link (:link page-meta)
        page-title (:title page-meta)
        page-summary (extract-tfa-text page)]
    (list
      (post/make :link page-link :title page-title :summary page-summary
                 :author tfa-author :date (today)))))

(deftype TFACrawler []
  Crawler
  (parse [this link]
    (let [{url :url} link
          get-content (grab-content url)]
      (parse-tfa (get-content)))))


(defn create
  "Create a today-featured-article crawler."
  [options]
  (TFACrawler.))
