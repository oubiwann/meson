(ns meson.client.impl.operator
  "v1 Operator HTTP API functions common to masters and agents."
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

(defn get-executors
  "Queries about all the executors known to the master/agent."
  [this]
  (call this :get-executors))

(defn get-flags
  "Retrieve the master/agent overall flag configuration."
  [this]
  (call this :get-flags))

(defn get-frameworks
  "Retrieve information about all the frameworks known to the master/agent."
  [this]
  (call this :get-frameworks))

(defn get-health
  "Retrieve health status of the master/agent."
  [this]
  (call this :get-health))

(defn get-logging-level
  "Retrieve the master/agent logging level."
  [this]
  (call this :get-logging-level))

(defn get-metrics
  "Snapshot of the current metrics. If the optional `timeout` is set in the call,
   it will be used to determine the maximum amount of time the API will take to respond.
   Some metrics may not be included if the timeout is exceeded."
  ([this]
   (call this :get-metrics))
  ([this payload]
   (call this :get-metrics payload)))

(defn get-operations
  "List of all offer operations throughout the cluster (master API) or known to the
   agent (agent API). Does not including LAUNCH or LAUNCH_GROUP, which can be retrieved
   with get-tasks."
  [this]
  (call this :get-operations))

(defn get-state
  "Retrieve overall cluster state (master API) or full state of the agent (agent API)."
  [this]
  (call this :get-state))

(defn get-tasks
  "All tasks known to the master or agent."
  [this]
  (call this :get-tasks))

(defn get-version
  "Retrieve master/agent version information."
  [this]
  (call this :get-version))

(defn list-files
  "Retrieve file listing for a directory `path` in the master/agent."
  [this payload]
  (call this :list-files payload))

(defn read-file
  "Reads data from a file on the master/agent. This call takes the `path` of the
   file to be read, the `offset` to start reading, and the maximum number of
   bytes to read (`length`)."
  [this payload]
  (call this :read-file payload))

(defn set-logging-level
  "Sets logging verbosity `level` for a specified `duration`. Mesos uses glog for logging.
   (https://github.com/google/glog)
   The library only uses verbose logging which means nothing will be output unless the
   verbosity level is set (by default it's 0, libprocess uses levels 1,2, and 3)."
  [this payload]
  (call this :set-logging-level payload))

(def behaviour
  {:get-executors get-executors
   :get-flags get-flags
   :get-frameworks get-frameworks
   :get-health get-health
   :get-logging-level get-logging-level
   :get-metrics get-metrics
   :get-operations get-operations
   :get-state get-state
   :get-tasks get-tasks
   :get-version get-version
   :list-files list-files
   :read-file read-file
   :set-logging-level set-logging-level})