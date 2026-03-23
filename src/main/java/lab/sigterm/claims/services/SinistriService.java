package lab.sigterm.claims.services;

import java.util.List;

import lab.sigterm.claims.model.dtos.SinistroDto;

public interface SinistriService {

  List<SinistroDto> getAllSinistri();

  SinistroDto getSinistroById(int id);

  List<SinistroDto> getSinistriByTarga(String targa);

  void createSinistro(SinistroDto sinistroDto);

}
