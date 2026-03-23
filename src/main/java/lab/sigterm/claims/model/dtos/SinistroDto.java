package lab.sigterm.claims.model.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinistroDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Date dataSinistro;
  private String descrizione;
  private String targaVeicoloA;
  private String conducenteA;
  private String targaVeicoloB;
  private String conducenteB;

}
