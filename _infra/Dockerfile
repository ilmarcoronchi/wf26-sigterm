# ============================================================
# Stage 1: WildFly server (solo layer WildFly, cambia raramente)
# ============================================================
FROM quay.io/wildfly/wildfly:26.1.2.Final-jdk17 AS wildfly-server


# ============================================================
# Stage 2: Immagine runtime con WAR applicativo
# ============================================================
FROM eclipse-temurin:17-jdk-jammy

ARG JBOSS_HOME=/opt/jboss/wildfly

RUN groupadd -r jboss && useradd -r -g jboss -m -d /opt/jboss jboss

COPY --from=wildfly-server --chown=jboss:jboss /opt/jboss/wildfly ${JBOSS_HOME}

RUN ${JBOSS_HOME}/bin/add-user.sh -m -u admin -p Secret99 --silent

COPY --chown=jboss:jboss target/sigterm.war ${JBOSS_HOME}/standalone/deployments/

USER jboss
WORKDIR ${JBOSS_HOME}

EXPOSE 8080 9990
ENTRYPOINT ["bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
