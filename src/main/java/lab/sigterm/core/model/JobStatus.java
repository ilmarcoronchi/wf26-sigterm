package lab.sigterm.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobStatus {
  private String id;
  private String status; // QUEUED, RUNNING, DONE, INTERRUPTED
  private String result;
}