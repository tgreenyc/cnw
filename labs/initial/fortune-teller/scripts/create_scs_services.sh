#!/usr/bin/env bash

cf cs p-mysql 100mb fortune-db
cf cs p-config-server standard config-server
cf cs p-service-registry standard service-registry
cf cs p-circuit-breaker-dashboard standard circuit-breaker
