package lab.sigterm.motor.repos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import lab.sigterm.motor.model.entities.VeicoloEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class VeicoloRepo {

  private Map<String, VeicoloEntity> veicoloMap = new HashMap<>();

  public List<VeicoloEntity> getAll() {
    return veicoloMap.values().stream().toList();
  }

  public VeicoloEntity getByTarga(String targa) {
    return veicoloMap.get(targa);
  }

  public void save(VeicoloEntity veicolo) {
    veicoloMap.put(veicolo.getTarga(), veicolo);
    log.info("Saved veicolo with targa: {}", veicolo.getTarga());
  }

  @PostConstruct
  public void init() {
    veicoloMap.put("AA000BB", new VeicoloEntity("AA000BB", "Fiat", "Panda", 2020));
    veicoloMap.put("CC111DD", new VeicoloEntity("CC111DD", "Alfa Romeo", "Giulia", 2022));
    log.info(">>>>>>>>>>>>>>>>>>>> VeicoloRepo initialized!!!");
  }

}
