package lab.sigterm.core.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class ShutdownLoggingListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    log.info("### Webapp avviata correttamente ###");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    log.info("!!! [SHUTDOWN LOG] Ricevuto segnale di stop nel Listener !!!");
    System.err.println("!!! [SHUTDOWN LOG] Ricevuto segnale di stop nel Listener !!!");
  }
}