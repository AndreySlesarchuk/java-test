package by.atmm.java.telegram_bot.ratelimiter.impl;

import by.atmm.java.telegram_bot.ratelimiter.RateLimiter;
import by.atmm.java.telegram_bot.ratelimiter.model.Request;
import by.atmm.java.telegram_bot.ratelimiter.model.TimeFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class SlidingWindowRateLimiter extends RateLimiter {

  private final Map<String, UserRequests> storage;

  private final DateTimeService dateTimeService;

  public SlidingWindowRateLimiter() {
    super(5, new TimeFrame(1, ChronoUnit.MINUTES));
    this.storage = new HashMap<>();
    this.dateTimeService = LocalDateTime::now;
  }

  public SlidingWindowRateLimiter(int limit, TimeFrame timeFrame, DateTimeService dateTimeService) {
    this(limit, timeFrame, new ConcurrentHashMap<>(), dateTimeService);
  }

  SlidingWindowRateLimiter(int limit, TimeFrame timeFrame, Map<String, UserRequests> storage, DateTimeService dateTimeService) {
    super(limit, timeFrame);
    this.storage = storage;
    this.dateTimeService = dateTimeService;
  }

  @Override
  public boolean hit(Request request) {
    Objects.requireNonNull(request);

    var userId = request.getUserId();
    var current = dateTimeService.currentTime();
    // atomic
    var userRequests = storage.compute(userId, (k, v) -> v == null ? new UserRequests() : v);
    synchronized (userRequests) {
      userRequests.removeExpiredRequests(current, timeFrame);
      userRequests.add(request.getTime());
      return userRequests.size() <= rateLimit;
    }
  }
}
