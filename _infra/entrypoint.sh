#!/bin/bash
export PS4='+ $(date "+%Y-%m-%d %H:%M:%S.%3N") '
set -x

JBOSS_HOME=/opt/jboss/wildfly

# Lancia WildFly in background
$JBOSS_HOME/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 -Djboss.shutdown.forceHalt=false -Djboss.shutdown.timeout=60 -Djboss.as.management.blocking.timeout=60 &
PID=$!

echo "PID is $PID"

shutdown() {
  echo ">>>>>>>>>>>>>>>>>>>>>> SIGTERM intercettato → suspend WildFly <<<<<<<<<<<<<<<<<<<<<<<<<<<"

  $JBOSS_HOME/bin/jboss-cli.sh --connect command=":suspend"

#  echo "attendo drain..."
#  sleep 10

#  echo "shutdown WildFly"
#  $JBOSS_HOME/bin/jboss-cli.sh --connect command=":shutdown"

  wait $PID
  echo ">>>>>>>>>>>WildFly Shutdown completed"
}

trap shutdown SIGTERM

wait $PID