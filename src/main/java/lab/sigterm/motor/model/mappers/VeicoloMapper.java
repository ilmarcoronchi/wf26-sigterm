package lab.sigterm.motor.model.mappers;

import lab.sigterm.motor.model.dtos.VeicoloDto;
import lab.sigterm.motor.model.entities.VeicoloEntity;

public class VeicoloMapper {

  public static VeicoloDto toDto(VeicoloEntity entity) {
    if (entity == null) {
      return null;
    }
    return new VeicoloDto(entity.getTarga(), entity.getMarca(), entity.getModello(), entity.getAnno());
  }

  public static VeicoloEntity toEntity(VeicoloDto dto) {
    if (dto == null) {
      return null;
    }
    return new VeicoloEntity(dto.getTarga(), dto.getMarca(), dto.getModello(), dto.getAnno());
  }

}
