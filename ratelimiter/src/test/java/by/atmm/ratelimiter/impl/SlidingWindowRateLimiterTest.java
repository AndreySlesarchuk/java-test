package by.atmm.ratelimiter.impl;

import by.atmm.ratelimiter.RateLimiter;
import by.atmm.ratelimiter.model.Request;
import by.atmm.ratelimiter.model.TimeFrame;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import static java.time.LocalDateTime.of;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SlidingWindowRateLimiterTest {

  public static final String USER_ID = "1";

  private RateLimiter rateLimiter;

  @Test
  void should_reject_request_if_more_than_limit() {
    // given
    var time = of(2000, 1, 1, 1, 1);
    var userIdToRequests = new HashMap<String, UserRequests>();
    UserRequests userRequests = new UserRequests();
    userRequests.add(time.plusSeconds(1L));
    userRequests.add(time.plusSeconds(2L));
    userIdToRequests.put(USER_ID, userRequests);
    var limit = 2;
    var timeFrame = new TimeFrame(1L, ChronoUnit.MINUTES);
    var request = new Request(time, USER_ID);
    rateLimiter = new SlidingWindowRateLimiter(limit, timeFrame, userIdToRequests, () -> time);

    // when
    boolean hit = rateLimiter.hit(request);

    // then
    assertFalse(hit);

  }

  @Test
  void should_allow_request_if_less_than_limit() {
    // given
    var time = of(2000, 1, 1, 1, 0);
    var userIdToRequests = new HashMap<String, UserRequests>();
    UserRequests userRequests = new UserRequests();
    userRequests.add(time.plusSeconds(1L));
    userIdToRequests.put(USER_ID, userRequests);
    var limit = 2;
    var timeFrame = new TimeFrame(1L, ChronoUnit.MINUTES);
    Request request = new Request(time, USER_ID);
    rateLimiter = new SlidingWindowRateLimiter(limit, timeFrame, userIdToRequests, () -> time);

    // when
    boolean hit = rateLimiter.hit(request);

    // then
    assertTrue(hit);

  }
}