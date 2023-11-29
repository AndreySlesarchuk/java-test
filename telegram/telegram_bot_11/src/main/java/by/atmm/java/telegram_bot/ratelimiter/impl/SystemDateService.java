package by.atmm.java.telegram_bot.ratelimiter.impl;

import java.time.LocalDateTime;

public class SystemDateService implements DateTimeService {
  @Override
  public LocalDateTime currentTime() {
    return LocalDateTime.now();
  }
}
