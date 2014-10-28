(ns shire-digest.crawler.xml
  "XML related routines."
  (:require [clojure.string :as string]))


(def entities [[#"&reg;" "&#174;"]
               [#"&trade;" "&#8482;"]])


(defn- clean-unreferenced-entity
  "Replace unreferenced entity with decimal value.
  
  See also: http://www.w3.org/TR/xhtml1/dtds.html#h-A2"
  [content]
  (reduce #(apply string/replace %1 %2) content entities))


(defn clean
  "Cleanup a document."
  [content]
  (-> content
      clean-unreferenced-entity))
