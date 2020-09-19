(ns meson.client.impl.master.operator
  "v1 Operator HTTP API functions for masters."
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

(defn create-volumes
  [this payload]
  :not-implemented)

(defn deactivate-agent [this payload]
  :not-implemented)

(defn destroy-volumes [this payload]
  :not-implemented)

(defn drain-agent [this payload]
  :not-implemented)

(defn get-agents [this]
  :not-implemented)

(defn get-maintenance-schedule [this]
  :not-implemented)

(defn get-maintenance-status [this]
  :not-implemented)

(defn get-master [this]
  :not-implemented)

(defn get-quota [this]
  :not-implemented)

(defn get-roles [this]
  :not-implemented)

(defn get-weights [this]
  :not-implemented)

(defn grow-volume [this payload]
  :not-implemented)

(defn mark-agent-gone [this payload]
  :not-implemented)

(defn reactivate-agent [this payload]
  :not-implemented)

(defn reserve-resources [this payload]
  :not-implemented)

(defn shrink-volume [this payload]
  :not-implemented)

(defn start-maintenance [this payload]
  :not-implemented)

(defn stop-maintenance [this payload]
  :not-implemented)

(defn unreserve-resources [this payload]
  :not-implemented)

(defn update-maintenance-schedule [this payload]
  :not-implemented)

(defn update-quota [this payload]
  :not-implemented)

(defn update-weights [this payload]
  :not-implemented)

(def behaviour
  {:create-volumes create-volumes
   :deactivate-agent deactivate-agent
   :destroy-volumes destroy-volumes
   :drain-agent drain-agent
   :get-agents get-agents
   :get-maintenance-schedule get-maintenance-schedule
   :get-maintenance-status get-maintenance-status
   :get-master get-master
   :get-quota get-quota
   :get-roles get-roles
   :get-weights get-weights
   :grow-volume grow-volume
   :mark-agent-gone mark-agent-gone
   :reactivate-agent reactivate-agent
   :reserve-resources reserve-resources
   :shrink-volume shrink-volume
   :start-maintenance start-maintenance
   :stop-maintenance stop-maintenance
   :unreserve-resources unreserve-resources
   :update-maintenance-schedule update-maintenance-schedule
   :update-quota update-quota
   :update-weights update-weights})
