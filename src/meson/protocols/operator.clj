(ns meson.protocols.operator
  "Mesos HTTP v1 Operator API endpoints that are common to masters and agents.

  v1 Operator endpoints: https://mesos.apache.org/documentation/latest/operator-http-api/"

  (:refer-clojure :exclude [read]))

(defprotocol IOperator
  "v1 Operator Interface endpoints common to masters and agents.
   
   See:
   * https://mesos.apache.org/documentation/latest/operator-http-api/#master-api
   * https://mesos.apache.org/documentation/latest/operator-http-api/#agent-api"

  (get-executors [this]
    "Queries about all the executors known to the master/agent.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_executors
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_executors-1")

  (get-flags [this]
    "Retrieve the master/agent overall flag configuration.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_flags
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_flags-1")

  (get-frameworks [this]
    "Retrieve information about all the frameworks known to the master/agent.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_frameworks
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_frameworks-1")

  (get-health [this]
    "Retrieve health status of the master/agent.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_health
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_health-1")

  (get-logging-level [this]
    "Retrieve the master/agent logging level.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_logging_level
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_logging_level-1")

  (get-metrics [this] [this payload]
    "Snapshot of the current metrics. If the optional `timeout` is set in the call,
     it will be used to determine the maximum amount of time the API will take to respond.
     Some metrics may not be included if the timeout is exceeded.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_metrics
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_metrics-1")

  (get-operations [this]
    "List of all offer operations throughout the cluster (master API) or known to the
     agent (agent API). Does not including LAUNCH or LAUNCH_GROUP, which can be retrieved
     with get-tasks.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_operations
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_operations-1")

  (get-state [this]
    "Retrieve overall cluster state (master API) or full state of the agent (agent API).
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_state
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_state-1")

  (get-tasks [this]
    "All tasks known to the master or agent.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_tasks
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_tasks-1")

  (get-version [this]
    "Retrieve master/agent version information.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_version
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_version-1")

  (list-files [this payload]
    "Retrieve file listing for a directory `path` in the master/agent.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#list_files
    * https://mesos.apache.org/documentation/latest/operator-http-api/#list_files-1")

  (read-file [this payload]
    "Reads data from a file on the master/agent. This call takes the `path` of the
     file to be read, the `offset` to start reading, and the maximum number of
     bytes to read (`length`).
    * https://mesos.apache.org/documentation/latest/operator-http-api/#read_file
    * https://mesos.apache.org/documentation/latest/operator-http-api/#read_file-1")

  (set-logging-level [this payload]
    "Sets logging verbosity `level` for a specified `duration`. Mesos uses glog for logging.
     (https://github.com/google/glog)
     The library only uses verbose logging which means nothing will be output unless the
     verbosity level is set (by default it's 0, libprocess uses levels 1,2, and 3).
    * https://mesos.apache.org/documentation/latest/operator-http-api/#set_logging_level
    * https://mesos.apache.org/documentation/latest/operator-http-api/#set_logging_level-1"))
