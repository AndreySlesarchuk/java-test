package by.atmm.ratelimiter.model;

import by.atmm.ratelimiter.common.Validation;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class TimeFrame {
  private final long amount;

  private final ChronoUnit chronoUnit;

  public TimeFrame(long amount, ChronoUnit chronoUnit) {
    Validation.requirePositive(amount, "Amount of time cannot be negative");
    this.amount = amount;
    this.chronoUnit = Objects.requireNonNull(chronoUnit, "Amount of time cannot be null");
  }

  public long getAmount() {
    return amount;
  }

  public ChronoUnit getChronoUnit() {
    return chronoUnit;
  }
}
