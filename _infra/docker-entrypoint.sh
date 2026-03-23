#!/bin/sh
set -e

# Entrypoint that starts WildFly in background and traps SIGTERM to invoke jboss-cli shutdown
# The script will start WildFly, register a trap for SIGTERM/SIGINT and call the management CLI
# to request a graceful shutdown; Docker will still enforce a SIGKILL after its timeout.
JBOSS_HOME=${JBOSS_HOME:-/opt/jboss/wildfly}

echo "[$(date +%FT%T%z)] Entrypoint: starting WildFly in background" >&2

"${JBOSS_HOME}/bin/standalone.sh" -b 0.0.0.0 -bmanagement 0.0.0.0 -Djboss.shutdown.forceHalt=false &
SERVER_PID=$!

graceful_shutdown() {
	echo "[$(date +%FT%T%z)] Entrypoint: SIGTERM received, polling internal endpoint then requesting graceful shutdown" >&2

	# Finally request a normal shutdown via management CLI
	echo "[$(date +%FT%T%z)] Entrypoint: requesting WildFly shutdown via jboss-cli" >&2
	"${JBOSS_HOME}/bin/jboss-cli.sh" --connect --command=":shutdown(suspend-timeout=-1)" || true

}

trap 'graceful_shutdown' TERM INT

# wait for the server to exit normally
wait ${SERVER_PID}
EXIT_CODE=$?
echo "[$(date +%FT%T%z)] Entrypoint: WildFly exited (no trap) with code ${EXIT_CODE}" >&2
exit ${EXIT_CODE}
