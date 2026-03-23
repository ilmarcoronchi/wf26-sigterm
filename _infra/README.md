# Wildfly Provisioning


```dos
SET JAVA_HOME=d:/openjdk-17.0.2
SET WF_HOME=D:/wildfly-26.1.2-api

d:/galleon-6.0.6.Final/bin/galleon.bat install wildfly:current#26.1.2.Final ^
  --dir=%WF_HOME% ^
  --default-configs=standalone/standalone.xml ^
  --layers=web-server,web-console,cdi,jaxrs,core-tools ^
  --verbose


:: register admin user
SET JAVA_HOME=d:/openjdk-17.0.2
D:/wildfly-26.1.2-api/bin/add-user.bat -m -u admin -p Secret99
```


NB: non confondere i 2 layer
- `management` (API) =>  http://127.0.0.1:9990/management
- `web-console` (UI) => http://127.0.0.1:9990/console/index.html

