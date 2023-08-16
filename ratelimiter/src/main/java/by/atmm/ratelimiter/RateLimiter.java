package by.atmm.ratelimiter;

import by.atmm.ratelimiter.model.Request;
import by.atmm.ratelimiter.model.TimeFrame;

import java.util.Objects;

public abstract class RateLimiter {
  protected final int rateLimit;

  protected final TimeFrame timeFrame;

  /**
   * @param limit     non negative
   * @param timeFrame Time frame not null
   */

  protected RateLimiter(int limit, TimeFrame timeFrame) {
    this.rateLimit = limit;
    this.timeFrame = Objects.requireNonNull(timeFrame, "TimeFrame of time cannot be null");
  }

  public abstract boolean hit(Request request);
}
