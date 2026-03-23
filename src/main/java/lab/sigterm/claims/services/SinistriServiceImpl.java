package lab.sigterm.claims.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import lab.sigterm.claims.model.dtos.SinistroDto;
import lab.sigterm.claims.model.mappers.SinistroMapper;
import lab.sigterm.claims.repos.SinistroRepo;

@ApplicationScoped
public class SinistriServiceImpl implements SinistriService {

  @Inject
  SinistroRepo sinistroRepo;

  @Override
  public List<SinistroDto> getAllSinistri() {
    return sinistroRepo.getAll().stream().map(SinistroMapper::toDto).collect(Collectors.toList());
  }

  @Override
  public SinistroDto getSinistroById(int id) {
    return SinistroMapper.toDto(sinistroRepo.getById(id));
  }

  @Override
  public List<SinistroDto> getSinistriByTarga(String targa) {
    return sinistroRepo.getByTarga(targa).stream().map(SinistroMapper::toDto).collect(Collectors.toList());
  }

  @Override
  public void createSinistro(SinistroDto sinistroDto) {
    sinistroRepo.save(SinistroMapper.toEntity(sinistroDto));
  }

}
