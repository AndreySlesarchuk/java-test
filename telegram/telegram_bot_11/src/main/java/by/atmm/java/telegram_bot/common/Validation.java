package by.atmm.java.telegram_bot.common;

import by.atmm.java.telegram_bot.exception.ValidationException;

public class Validation {
  public static long requirePositive(long number, String message) {
    if (number < 0)
      throw new ValidationException(message);
    return number;
  }
}
