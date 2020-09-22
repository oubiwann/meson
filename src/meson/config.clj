(ns meson.config
  (:require [leiningen.core.project :as project])
  (:refer-clojure :exclude [name]))

(def all (project/read))

(def project-url (:url all))

(def client-version (:version all))

(def meson (:meson all))

(def log-level (:log-level meson))

(def log-ns (:log-ns meson))

(def mesos (:mesos meson))

(def cluster-deployment (:cluster-deployment mesos))

(def cluster-type (:cluster-type mesos))

(def docker (:docker mesos))

(def docker-container-name (:container-name docker))

(def docker-image-name (:image-name docker))

(def docker-mesos-ports (:mesos-ports docker))

(def docker-marathon-ports (:marathon-ports docker))

(def docker-agent (:agent docker))

(def docker-master (:master docker))
