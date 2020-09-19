(ns meson.client.impl.agent.operator
  "v1 Operator HTTP API functions for agents."
  (:require [clojure.data.json :as json]
            [meson.http.core :as http]
            [meson.util.core :as util])
  (:import [clojure.lang Keyword]))

(def operator-path "api/v1")

(defn call
  "HTTP call to the Mesos operator api."
  ([this ^Keyword type]
   (call this type nil))
  ([this ^Keyword type payload]
   (call this type payload http/json-content-type))
  ([this ^Keyword type payload content-type]
   (call this type payload content-type {}))
  ([this ^Keyword type payload content-type opts]
   (let [data {:type (util/keyword->upper type)
               (util/keyword->lower type) payload}]
     (http/post
      this
      operator-path
      :body (json/write-str data)
      :opts (into opts {:content-type content-type
                        :accept content-type})))))

(defn add-resource-provider-config [this payload]
  :not-implemented)

(defn attach-container-input [this payload]
  :not-implemented)

(defn attach-container-output [this payload]
  :not-implemented)

(defn get-containers
  ([this]
   :not-implemented)
  ([this payload]
   :not-implemented))

(defn get-resource-providers [this]
  :not-implemented)

(defn kill-nested-containers [this payload]
  :not-implemented)

(defn launch-nested-container [this payload]
  :not-implemented)

(defn launch-nested-container-session [this payload]
  :not-implemented)

(defn prune-images
  ([this]
   :not-implemented)
  ([this payload]
   :not-implemented))

(defn remove-nested-container [this payload]
  :not-implemented)

(defn remove-resource-provider-config [this payload]
  :not-implemented)

(defn update-resource-provider-config [this payload]
  :not-implemented)

(defn wait-nested-container [this payload]
  :not-implemented)

(def behaviour
  {:add-resource-provider-config add-resource-provider-config
   :attach-container-input attach-container-input
   :attach-container-output attach-container-output
   :get-containers get-containers
   :get-resource-providers get-resource-providers
   :kill-nested-containers kill-nested-containers
   :launch-nested-container launch-nested-container
   :launch-nested-container-session launch-nested-container-session
   :prune-images prune-images
   :remove-nested-container remove-nested-container
   :remove-resource-provider-config remove-resource-provider-config
   :update-resource-provider-config update-resource-provider-config
   :wait-nested-container wait-nested-container})
