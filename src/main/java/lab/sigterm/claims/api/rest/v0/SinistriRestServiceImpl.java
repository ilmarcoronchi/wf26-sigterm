package lab.sigterm.claims.api.rest.v0;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import lab.sigterm.claims.model.dtos.SinistroDto;
import lab.sigterm.claims.services.SinistriService;
import lab.sigterm.core.aop.Audited;
import lombok.extern.slf4j.Slf4j;

@Audited
@Slf4j
@ApplicationScoped
public class SinistriRestServiceImpl implements SinistriRestService {

  @Inject
  SinistriService sinistroService;

  @Override
  public List<SinistroDto> getAllSinistri() {
    return sinistroService.getAllSinistri();
  }

  @Override
  public SinistroDto getSinistroById(int id) {
    log.info("GET sinistro by id: {}", id);
    return sinistroService.getSinistroById(id);
  }

  @Override
  public List<SinistroDto> getSinistriByTarga(String targa) {
    log.info("GET sinistri by targa: {}", targa);
    return sinistroService.getSinistriByTarga(targa);
  }

  @Override
  public Response createSinistro(SinistroDto sinistroDto) {
    log.info("POST sinistro: {}", sinistroDto);
    sinistroService.createSinistro(sinistroDto);
    return Response.status(Response.Status.CREATED).entity(sinistroDto).build();
  }

}
