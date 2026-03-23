package lab.sigterm.motor.services;

import java.util.List;

import lab.sigterm.motor.model.dtos.VeicoloDto;

public interface VeicoloService {

  List<VeicoloDto> getAllVeicoli();

  VeicoloDto getVeicoloByTarga(String targa);

  void createVeicolo(VeicoloDto veicoloDto);

}
