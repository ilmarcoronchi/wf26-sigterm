package lab.sigterm.claims.api.rest.v0;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lab.sigterm.claims.model.dtos.SinistroDto;

@Path("/v0/sinistri")
public interface SinistriRestService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/")
  List<SinistroDto> getAllSinistri();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  SinistroDto getSinistroById(@PathParam("id") int id);

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/targa/{targa}")
  List<SinistroDto> getSinistriByTarga(@PathParam("targa") String targa);

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/")
  Response createSinistro(SinistroDto sinistroDto);

}
