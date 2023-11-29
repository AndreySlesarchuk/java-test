package by.atmm.java.telegram_bot.ratelimiter.model;

import by.atmm.java.telegram_bot.common.Validation;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class TimeFrame {
  private final long amountOfTime;

  private final ChronoUnit chronoUnit;

  public TimeFrame(long amount, ChronoUnit chronoUnit) {
    Validation.requirePositive(amount, "Amount of time cannot be negative");
    this.amountOfTime = amount;
    this.chronoUnit = Objects.requireNonNull(chronoUnit, "Amount of time cannot be null");
  }

  public long getAmountOfTime() {
    return amountOfTime;
  }

  public ChronoUnit getChronoUnit() {
    return chronoUnit;
  }
}
