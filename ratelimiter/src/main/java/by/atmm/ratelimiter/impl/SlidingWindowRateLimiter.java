package by.atmm.ratelimiter.impl;

import by.atmm.ratelimiter.RateLimiter;
import by.atmm.ratelimiter.model.Request;
import by.atmm.ratelimiter.model.TimeFrame;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SlidingWindowRateLimiter extends RateLimiter {

  private final Map<String, UserRequests> storage;

  private final DateTimeService dateTimeService;

  public SlidingWindowRateLimiter(int limit, TimeFrame timeFrame, DateTimeService dateTimeService) {
    this(limit, timeFrame, new HashMap<>(), dateTimeService);
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
    var userRequests = storage.get(userId);
    var current = dateTimeService.currentTime();
    userRequests.removeExpiredRequests(current, timeFrame);
    userRequests.add(request.getTime());
    return userRequests.size() <= rateLimit;

  }
}
