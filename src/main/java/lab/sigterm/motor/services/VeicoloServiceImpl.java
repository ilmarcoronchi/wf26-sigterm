package lab.sigterm.motor.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import lab.sigterm.motor.model.dtos.VeicoloDto;
import lab.sigterm.motor.model.mappers.VeicoloMapper;
import lab.sigterm.motor.repos.VeicoloRepo;

@ApplicationScoped
public class VeicoloServiceImpl implements VeicoloService {

  @Inject
  VeicoloRepo veicoloRepo;

  @Override
  public List<VeicoloDto> getAllVeicoli() {
    return veicoloRepo.getAll().stream().map(VeicoloMapper::toDto).collect(Collectors.toList());
  }

  @Override
  public VeicoloDto getVeicoloByTarga(String targa) {
    return VeicoloMapper.toDto(veicoloRepo.getByTarga(targa));
  }

  @Override
  public void createVeicolo(VeicoloDto veicoloDto) {
    veicoloRepo.save(VeicoloMapper.toEntity(veicoloDto));
  }

}
