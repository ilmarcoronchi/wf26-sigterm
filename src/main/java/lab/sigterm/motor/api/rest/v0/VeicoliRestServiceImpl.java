package lab.sigterm.motor.api.rest.v0;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import lab.sigterm.core.aop.Audited;
import lab.sigterm.motor.model.dtos.VeicoloDto;
import lab.sigterm.motor.services.VeicoloService;
import lombok.extern.slf4j.Slf4j;

@Audited
@Slf4j
@ApplicationScoped
public class VeicoliRestServiceImpl implements VeicoliRestService {

  @Inject
  VeicoloService veicoloService;

  @Override
  public List<VeicoloDto> getAllVeicoli() {
    return veicoloService.getAllVeicoli();
  }

  @Override
  public VeicoloDto getVeicoloByTarga(String targa) {
    log.info("GET veicolo by targa: {}", targa);
    return veicoloService.getVeicoloByTarga(targa);
  }

  @Override
  public Response createVeicolo(VeicoloDto veicoloDto) {
    log.info("POST veicolo: {}", veicoloDto);
    veicoloService.createVeicolo(veicoloDto);
    return Response.status(Response.Status.CREATED).entity(veicoloDto).build();
  }

}
