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

    LocalDateTime dt1
        = LocalDateTime
        .parse("2018-11-03T12:45:30");

    // Prints the date
    System.out.println("Original LocalDateTime: "
        + dt1);

    // Display d1 in different formats
    // using format() method
    System.out.println("BASIC_ISO_DATE format: "
        + (DateTimeFormatter.BASIC_ISO_DATE)
        .format(dt1));
    System.out.println("BASIC_ISO_LOCAL_DATE_TIME format: "
        + (DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        .format(dt1));
    System.out.println("ISO_LOCAL_DATE format: "
        + (DateTimeFormatter.ISO_LOCAL_DATE)
        .format(dt1));
    System.out.println("ISO_DATE format: "
        + (DateTimeFormatter.ISO_DATE)
        .format(dt1));
    System.out.println("ISO_LOCAL_TIME format: "
        + (DateTimeFormatter.ISO_LOCAL_TIME)
        .format(dt1));

  }
}
