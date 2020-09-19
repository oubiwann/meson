(ns meson.protocols.master.operator
  "Mesos HTTP v1 Operator API endpoints for masters.

  v1 Operator master endpoints:
  https://mesos.apache.org/documentation/latest/operator-http-api/#master-api"

  (:refer-clojure :exclude [read]))

(defprotocol IMasterOperator
  "v1 Operator Interface endpoints for masters.
   
   See:
   * https://mesos.apache.org/documentation/latest/operator-http-api/#master-api"

  (create-volumes [this payload]
    "This call create persistent volumes on reserved resources.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#create_volumes")

  (deactivate-agent [this payload]
    "Deactivates the specified agent, preventing offers for that agent’s resources from being sent to schedulers until the agent is reactivated.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#deactivate_agent")

  (destroy-volumes [this payload]
    "This call destroys persistent volumes.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#destroy_volumes")

  (drain-agent [this payload]
    "Initiates draining on the specified agent.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#drain_agent")

  (get-agents [this]
    "This call retrieves information about all the agents known to the master.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#get_agents")

  (get-maintenance-schedule [this]
    "This call retrieves the cluster’s maintenance schedule.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#get_maintenance_schedule")

  (get-maintenance-status [this]
    "This call retrieves the cluster’s maintenance status.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#get_maintenance_status")

  (get-master [this]
    "This call retrieves information about the master.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#get_master")

  (get-quota [this]
    "This call retrieves the cluster’s configured quotas.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#get_quota")

  (get-roles [this]
    "Query the information about roles.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#get_roles")

  (get-weights [this]
    "This call retrieves the information about role weights.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#get_weights")

  (grow-volume [this payload]
    "This call grows the size of a persistent volume.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#grow_volume")

  (mark-agent-gone [this payload]
    "This call can be used by operators to assert that an agent instance has failed
     and is never coming back (e.g., ephemeral instance from cloud provider).
    * http://mesos.apache.org/documentation/latest/operator-http-api/#mark_agent_gone")

  (reactivate-agent [this payload]
    "Reactivates the specified agent, resuming offers for that agent’s resources
     if the agent was previously deactivated.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#reactivate_agent")

  (reserve-resources [this payload]
    "This call is used to update resource reservations.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#reserve_resources")

  (shrink-volume [this payload]
    "This call shrinks the size of a persistent volume.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#shrink_volume")

  (start-maintenance [this payload]
    "This call starts the maintenance of the cluster, this would bring a set of machines down.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#start_maintenance")

  (stop-maintenance [this payload]
    "Stops the maintenance of the cluster, this would bring a set of machines back up.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#stop_maintenance")

  (unreserve-resources [this payload]
    "This call unreserve resources dynamically on a specific agent.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#unreserve_resources")

  (update-maintenance-schedule [this payload]
    "This call updates the cluster’s maintenance schedule.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#update_maintenance_schedule")

  (update-quota [this payload]
    "This call updates the quota for the specified role(s). These configurations are
     applied in an all-or-nothing manner. To reset a role’s quota back to the default
     (no guarantees and no limits), simply update its quota with empty guarantees and
     limits fields.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#update_quota")

  (update-weights [this payload]
    "This call updates weights for specific role.
    * http://mesos.apache.org/documentation/latest/operator-http-api/#update_weights"))
