# ============================================================
# Stage 1: WildFly server
# ============================================================
FROM quay.io/wildfly/wildfly:26.1.2.Final-jdk17 AS wildfly-server

# ============================================================
# Stage 2: Runtime
# ============================================================
FROM eclipse-temurin:17-jdk-jammy

ENV JBOSS_HOME=/opt/jboss/wildfly
ENV DEPLOY_DIR=${JBOSS_HOME}/standalone/deployments
ENV CONFIG_DIR=${JBOSS_HOME}/standalone/configuration

RUN groupadd -r jboss && useradd -r -g jboss -m -d /opt/jboss jboss

# Copia i binari di WildFly
COPY --from=wildfly-server --chown=jboss:jboss /opt/jboss/wildfly ${JBOSS_HOME}

# Installazione Tini
RUN apt-get update && apt-get install -y --no-install-recommends tini && rm -rf /var/lib/apt/lists/*

# --- CONFIGURAZIONE PERSONALIZZATA ---
# Copiamo il TUO standalone.xml modificato sopra la configurazione di default
COPY --chown=jboss:jboss _infra/standalone.xml ${CONFIG_DIR}/standalone.xml

# --- DEPLOY ---
COPY --chown=jboss:jboss target/sigterm.war ${DEPLOY_DIR}/sigterm.war
RUN touch ${DEPLOY_DIR}/sigterm.war.dodeploy && chown jboss:jboss ${DEPLOY_DIR}/sigterm.war.dodeploy

USER jboss
WORKDIR ${JBOSS_HOME}

EXPOSE 8080 9990

# Tini gestisce i segnali, -s risolve il warning del subreaper
ENTRYPOINT ["/usr/bin/tini", "-v", "-s", "--", "/opt/jboss/wildfly/bin/standalone.sh"]

# Nota: i parametri -b 0.0.0.0 sovrascrivono i 127.0.0.1 nel file XML per l'accesso esterno
CMD ["-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-Djboss.shutdown.forceHalt=false"]