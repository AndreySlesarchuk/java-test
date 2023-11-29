package by.atmm.java.telegram_bot.ratelimiter;

import by.atmm.java.telegram_bot.ratelimiter.model.Request;
import by.atmm.java.telegram_bot.ratelimiter.model.TimeFrame;

import java.util.Objects;

public abstract class RateLimiter {
  protected final int rateLimit;

  protected final TimeFrame timeFrame;

  /**
   * @param rateLimit  number of attempts - non-negative
   * @param timeFrame Time frame not null
   */

  protected RateLimiter(int rateLimit, TimeFrame timeFrame) {
    this.rateLimit = rateLimit;
    this.timeFrame = Objects.requireNonNull(timeFrame, "TimeFrame of time cannot be null");
  }

  public abstract boolean hit(Request request);
}
