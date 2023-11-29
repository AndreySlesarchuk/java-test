package by.atmm.java.telegram_bot.ratelimiter.impl;

import by.atmm.java.telegram_bot.ratelimiter.model.TimeFrame;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

@Slf4j
public class UserRequests {
  private final Deque<LocalDateTime> queue;

  public UserRequests() {
    queue = new LinkedList<>();
  }

  public void add(LocalDateTime localDateTime) {
    queue.add(Objects.requireNonNull(localDateTime));
  }

  public void removeExpiredRequests(LocalDateTime current, TimeFrame timeFrame) {
    Objects.requireNonNull(current);
    Objects.requireNonNull(timeFrame);
    final var chronoUnit = timeFrame.getChronoUnit();
    queue.removeIf(userRequestTime -> {
      log.info("\ncurrent:         " + current + "\nuserRequestTime:" + userRequestTime + "\n");
      long l = Duration.between(userRequestTime, current).toMinutes();
      log.info("Duration: " + l) ;
      return l >= timeFrame.getAmountOfTime();
    });
  }

  public int size() {
    return queue.size();
  }

}
