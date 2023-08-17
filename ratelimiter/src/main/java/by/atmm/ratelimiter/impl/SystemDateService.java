package by.atmm.ratelimiter.impl;

import java.time.LocalDateTime;

public class SystemDateService implements DateTimeService {
  @Override
  public LocalDateTime currentTime() {
    return LocalDateTime.now();
  }
}
