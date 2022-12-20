package by.atmm.java.__early.__topics.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DataTimeFormat {

  public static void main(String[] args) {
    LocalDate anotherSummerDay = LocalDate.of(2022, 12, 21);
    LocalTime anotherTime = LocalTime.of(13, 31, 13);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(anotherSummerDay, anotherTime,
        ZoneId.of("Europe/Warsaw"));
    System.out.println(
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
            .format(zonedDateTime));
    System.out.println(
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
            .format(zonedDateTime));
    System.out.println(
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            .format(zonedDateTime));
    System.out.println(
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
            .format(zonedDateTime));

    var europeanDatePattern = "dd.MM.yyyy";
    var europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
    System.out.println(europeanDateFormatter.format(LocalDate.of(2022, 2, 22)));

    var fileDatePattern = "ddMMyyyykkmm";
    var fileDateFormatter = DateTimeFormatter.ofPattern(fileDatePattern);
    System.out.println(fileDateFormatter.format(LocalDateTime.now()));
  }
}
