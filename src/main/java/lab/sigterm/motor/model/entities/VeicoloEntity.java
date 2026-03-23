package lab.sigterm.motor.model.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeicoloEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String targa;
	private String marca;
	private String modello;
	private int anno;

}
