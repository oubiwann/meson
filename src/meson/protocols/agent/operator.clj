(ns meson.protocols.agent.operator
  "Mesos HTTP v1 Operator API endpoints for agents.

  v1 Operator master endpoints:
  https://mesos.apache.org/documentation/latest/operator-http-api/#agent-api"

  (:refer-clojure :exclude [read]))

(defprotocol IAgentOperator
  "v1 Operator Interface endpoints for agents.
   
   See:
   * https://mesos.apache.org/documentation/latest/operator-http-api/#agent-api"

  (add-resource-provider-config [this payload]
    "This call launches a Local Resource Provider on the agent with the specified ResourceProviderInfo.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#add_resource_provider_config")

  (attach-container-input [this payload]
    "This call attaches to the STDIN of the primary process of a container and streams input to it.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#attach_container_input")

  (attach-container-output [this payload]
    "This call attaches to the STDOUT and STDERR of the primary process of a container and streams
     its output back to the client.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#attach_container_output")

  (get-containers [this] [this payload]
    "This call retrieves information about containers running on this agent.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_containers")

  (get-resource-providers [this]
    "This call retrieves information about all the resource providers known to the agent.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#get_resource_providers")

  (kill-nested-containers [this payload]
    "This call initiates the destruction of a nested container.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#kill_nested_container")

  (launch-nested-container [this payload]
    "This call launches a nested container.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#launch_nested_container")

  (launch-nested-container-session [this payload]
    "This call launches a nested container whose lifetime is tied to the lifetime of the HTTP
     call establishing this connection.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#launch_nested_container_session")

  (prune-images [this] [this payload]
    "This call triggers garbage collection for container images.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#prune_images")

  (remove-nested-container [this payload]
    "This call triggers the removal of a nested container and its artifacts
     (e.g., the sandbox and runtime directories).
    * https://mesos.apache.org/documentation/latest/operator-http-api/#remove_nested_container")

  (remove-resource-provider-config [this payload]
    "This call terminates a given Local Resource Provider on the agent and prevents it from
     being launched again until the config is added back.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#remove_resource_provider_config")

  (update-resource-provider-config [this payload]
    "This call updates a Local Resource Provider on the agent with the specified ResourceProviderInfo.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#update_resource_provider_config")

  (wait-nested-container [this payload]
    "This call waits for a nested container to terminate or exit.
    * https://mesos.apache.org/documentation/latest/operator-http-api/#wait_nested_container"))
