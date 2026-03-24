FROM quay.io/wildfly/wildfly:26.1.2.Final-jdk17


USER root

ENV JBOSS_HOME=/opt/jboss/wildfly

# Create admin user for management console (non-interactive)
RUN ${JBOSS_HOME}/bin/add-user.sh -m -u admin -p Secret99 --silent || true

COPY _infra/entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh


COPY ../target/sigterm.war ${JBOSS_HOME}/standalone/deployments/


EXPOSE 8080 9990


USER jboss

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
#ENV LAUNCH_JBOSS_IN_BACKGROUND=true

ENTRYPOINT ["/entrypoint.sh"]


# ENTRYPOINT: null
# CMD passato da fuori