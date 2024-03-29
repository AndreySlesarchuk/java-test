package by.atmm.ratelimiter.impl;

import by.atmm.ratelimiter.model.TimeFrame;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

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
      long l = Duration.between(current, userRequestTime).toMinutes();
      return l > timeFrame.getAmount();
    });
  }

  public int size() {
    return queue.size();
  }

}
