package by.atmm.ratelimiter.impl;

import by.atmm.ratelimiter.RateLimiter;
import by.atmm.ratelimiter.model.Request;
import by.atmm.ratelimiter.model.TimeFrame;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter extends RateLimiter {

  private final Map<String, UserRequests> storage;

  private final DateTimeService dateTimeService;

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
