package by.atmm.spring_boot.async;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

  @Scheduled(fixedRate = 10000)
  public void performScheduledTask() {
    System.out.println("Scheduled task executed at " + System.currentTimeMillis());
  }
}
