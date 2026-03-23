package lab.sigterm.core.api.rest.v0;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * *NB Con l'annotazione @Path, diventa un CDI Bean con scope @Dependent (byd)
 * => sono "obligato a marcarlo come @ApplicationScoped
 * </pre>
 */
@Path("/")
@Slf4j
@ApplicationScoped
public class PingRestService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("ping")
  public String pong() {
    log.debug("ping");
    return "ping";
  }

}