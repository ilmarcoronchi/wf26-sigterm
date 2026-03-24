#!/bin/bash
export PS4='+ $(date "+%Y-%m-%d %H:%M:%S.%3N") '
set -x

JBOSS_HOME=/opt/jboss/wildfly

# Lancia WildFly in background
$JBOSS_HOME/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 &
PID=$!

echo ">>>> PID is $PID <<<<"

shutdown() {
  echo ">>> SIGTERM intercettato → suspend WildFly <<<<"
  $JBOSS_HOME/bin/jboss-cli.sh --connect command=":suspend"
  wait $PID
}

trap shutdown SIGTERM

wait $PID