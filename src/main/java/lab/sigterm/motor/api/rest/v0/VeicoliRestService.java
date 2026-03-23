package lab.sigterm.motor.api.rest.v0;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lab.sigterm.motor.model.dtos.VeicoloDto;

@Path("/v0/veicoli")
public interface VeicoliRestService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/")
  List<VeicoloDto> getAllVeicoli();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{targa}")
  VeicoloDto getVeicoloByTarga(@PathParam("targa") String targa);

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/")
  Response createVeicolo(VeicoloDto veicoloDto);

}
