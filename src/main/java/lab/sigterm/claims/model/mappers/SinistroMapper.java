package lab.sigterm.claims.model.mappers;

import lab.sigterm.claims.model.dtos.SinistroDto;
import lab.sigterm.claims.model.entities.SinistroEntity;

public class SinistroMapper {

  public static SinistroDto toDto(SinistroEntity entity) {
    if (entity == null) {
      return null;
    }
    return new SinistroDto(entity.getId(), entity.getDataSinistro(), entity.getDescrizione(), entity.getTargaVeicoloA(),
        entity.getConducenteA(), entity.getTargaVeicoloB(), entity.getConducenteB());
  }

  public static SinistroEntity toEntity(SinistroDto dto) {
    if (dto == null) {
      return null;
    }
    return new SinistroEntity(dto.getId(), dto.getDataSinistro(), dto.getDescrizione(), dto.getTargaVeicoloA(),
        dto.getConducenteA(), dto.getTargaVeicoloB(), dto.getConducenteB());
  }

}
