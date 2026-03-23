package lab.sigterm.claims.repos;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import lab.sigterm.claims.model.entities.SinistroEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class SinistroRepo {

  private Map<Integer, SinistroEntity> sinistroMap = new HashMap<>();
  private int maxId = 0;

  public List<SinistroEntity> getAll() {
    return sinistroMap.values().stream().toList();
  }

  public SinistroEntity getById(int id) {
    return sinistroMap.get(id);
  }

  public List<SinistroEntity> getByTarga(String targa) {
    return sinistroMap.values().stream()
        .filter(s -> s.getTargaVeicoloA().equalsIgnoreCase(targa) || s.getTargaVeicoloB().equalsIgnoreCase(targa))
        .toList();
  }

  public void save(SinistroEntity sinistro) {
    maxId++;
    sinistro.setId(maxId);
    sinistroMap.put(maxId, sinistro);
    log.info("Saved sinistro with id: {}", maxId);
  }

  @PostConstruct
  public void init() {
    sinistroMap.put(1, new SinistroEntity(1, new Date(), "Tamponamento in autostrada", "AA000BB", "Mario Rossi",
        "CC111DD", "Luigi Bianchi"));
    sinistroMap.put(2,
        new SinistroEntity(2, new Date(), "Urto in parcheggio", "CC111DD", "Luigi Bianchi", "AA000BB", "Mario Rossi"));
    maxId = 2;
    log.info(">>>>>>>>>>>>>>>>>>>> SinistroRepo initialized!!!");
  }

}
