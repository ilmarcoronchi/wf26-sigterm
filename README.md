# SIGTRM

https://github.com/wildfly/wildfly-container


Lo scopo è quello di verificare la gestione del SIGTERM e del SIGKILL di WF.

Occorre trasformare il SIGTERM nel comando 

`docker exec -it sigterm /opt/jboss/wildfly/bin/jboss-cli.sh --connect command=":suspend"`

che è quello che fa lo script `entrypoint.sh`

NB: deve avere EOL in formato Unix!!!


Per una questione di SOR è corretto che la gestione del  gracefulShutdown sia affidata all'orchestratore esterno.
NON a caso Docker prevede che all'interno del comando `docker stop` il parametro `-t` (timeout) che indica l'intervallo tra SIGTERM e SIGKILL.
Lo script intercetta il segnale SIGTERM e lo trasforma nel command=":suspend" la gestione dei timeout è "delegata" all'orchestratore esterno!!!
E' l'orchestratore che dopo il SIGTERM attende un timeout e invia il SIGKILL


---





NB: Il progetto utilizza il modulo

- http://127.0.0.1:9990/management
- http://127.0.0.1:9990/console


http://127.0.0.1:9990/console/index.html#runtime;path=standalone-server-column~standalone-host-gmktec!rss~jaxrs







