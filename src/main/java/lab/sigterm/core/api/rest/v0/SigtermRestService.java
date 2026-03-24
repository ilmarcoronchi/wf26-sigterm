package lab.sigterm.core.api.rest.v0;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import lombok.extern.slf4j.Slf4j;

@Path("/sigterm")
@Slf4j
@ApplicationScoped
public class SigtermRestService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("wait")
  public String wait(@QueryParam("seconds") int seconds) {
    log.info("Ricevuta richiesta di attesa: {} secondi", seconds);
    try {
      Thread.sleep(seconds * 1000L);

    } catch (InterruptedException e) {
      System.err.println(">>>>>>>>>>>>Attesa interrotta dopo richiesta di " + seconds + " secondi");
      log.warn("Attesa interrotta dopo richiesta di {} secondi", seconds);

      return "Attesa interrotta dopo richiesta di " + seconds + " secondi";
    }
    log.info(">>> Attesa di {} secondi completata", seconds);
    return "Ho aspettato " + seconds + " secondi";
  }

}
