package lab.sigterm.core.api.rest.v0;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lab.sigterm.core.model.JobStatus;
import lab.sigterm.core.services.JobService;
import lombok.extern.slf4j.Slf4j;

@Path("/jobs")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class JobRestService {

  @Inject
  JobService jobService;

  @POST
  @Path("/start")
  public Response start(@QueryParam("seconds") int seconds) {

    log.info("Ricevuta richiesta di avvio job: {} secondi", seconds);
    String jobId = jobService.submit(seconds);

    return Response.accepted().entity(Map.of("jobId", jobId)).build();
  }

  @GET
  @Path("/{id}")
  public Response status(@PathParam("id") String id) {
    JobStatus status = jobService.get(id);

    if (status == null) {
      return Response.status(404).build();
    }

    return Response.ok(status).build();
  }
}