(ns shire-digest.crawler.news.cnn
  "CNN world news crawler."
  (:require [shire-digest.meta.post :as post]
            [shire-digest.crawler.core :refer [Crawler parse]]
            [shire-digest.crawler.utils :refer [grab-url-as-resource]]
            [shire-digest.meta.utils :refer [today]]
            [net.cgrand.enlive-html :as html]))


(def author "cnn")
(def base-url "http://edition.cnn.com")
(defn- page-url [item] (str base-url item))

(defn- extract-news
  "Extract a news."
  [entity]
  (let [title (:content entity)
        link (page-url (-> entity :attrs :href))]
    (post/make :link link :title title :summary ""
               :author author :date (today))))

(defn- extract-news-items
  "Extract news items."
  [page]
  (let [html-page (html/html-resource page)
        bulletbin-news (html/select html-page [:ul.cnn_bulletbin :> :li :a])]
    (map extract-news bulletbin-news)))

(deftype CNNCrawler [options]
  Crawler
  (parse [this link]
    (let [news-count (:count options 5)
          {url :url} link
          get-page (grab-url-as-resource url)
          news (extract-news-items (get-page))]
      (take news-count news))))

(defn create
  "Create a cnn world news crawler."
  [options]
  (CNNCrawler. options))
