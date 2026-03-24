package lab.sigterm.core.services;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.enterprise.context.ApplicationScoped;

import lab.sigterm.core.model.JobStatus;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class JobService {

  private final Map<String, JobStatus> jobs = new ConcurrentHashMap<>();
  private final ExecutorService executor = Executors.newFixedThreadPool(4);

  public String submit(int seconds) {
    String jobId = UUID.randomUUID().toString();

    JobStatus status = new JobStatus(jobId, "QUEUED", null);
    jobs.put(jobId, status);

    executor.submit(() -> runJob(jobId, seconds));

    return jobId;
  }

  private void runJob(String jobId, int seconds) {
    JobStatus status = jobs.get(jobId);
    status.setStatus("RUNNING");

    try {
      log.info("Job {} partito, durata {} sec", jobId, seconds);

      Thread.sleep(seconds * 1000L);

      status.setStatus("DONE");
      status.setResult("Completato dopo " + seconds + " secondi");

      log.info("Job {} completato", jobId);

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();

      status.setStatus("INTERRUPTED");
      status.setResult("Interrotto");

      log.warn("Job {} interrotto", jobId);
      System.err.println(">>>>>>>>>>>>>Job " + jobId + " interrotto: ");
    }
  }

  public JobStatus get(String jobId) {
    return jobs.get(jobId);
  }
}