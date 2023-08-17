package by.atmm.ratelimiter.impl;

import java.time.LocalDateTime;

public class MockDateTimeService implements DateTimeService{
  @Override
  public LocalDateTime currentTime() {
    return LocalDateTime.of(1999,1,1,1,1);
  }
}
