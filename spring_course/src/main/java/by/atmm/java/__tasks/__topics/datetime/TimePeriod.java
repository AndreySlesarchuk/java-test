package by.atmm.java.__tasks.__topics.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import by.atmm.java.__tasks.__topics.utils.MyDateFormat;


/**
 * Created by Andrey Slesarchuk on 12/14/2020.
 */
public class TimePeriod {

  private Date startTime;

  private Date endTime;

  public TimePeriod() {
  }

  public TimePeriod(String startTime, String endTime) {
    this.startTime = new Date(startTime);
    this.endTime = new Date(endTime);
  }

  public static void main(String[] args) throws ParseException {
    Set<TimePeriod> timePeriods = new HashSet<>();
    // timePeriods.add(new TimePeriod(1606802400000, 1606804200000))); //
    // 2020/12/01 09:00:00", "2020/12/01 09:30:00"));
    timePeriods.add(new TimePeriod("2020/12/01 08:00:00", "2020/12/01 08:30:00"));
    timePeriods.add(new TimePeriod("2020/12/01 10:00:00", "2020/12/01 10:30:00"));
    timePeriods.add(new TimePeriod("2020/12/02 09:00:00", "2020/12/02 09:30:00"));
    timePeriods.add(new TimePeriod("2020/12/03 09:00:00", "2020/12/03 09:30:00"));
    timePeriods.add(new TimePeriod("2020/12/04 09:00:00", "2020/12/04 09:30:00"));

    timePeriods.stream().forEach(tp -> System.out.println("-> : " + tp.toString()));
    Map<LocalDate, Integer> m1 = new HashMap<>();
    for (TimePeriod tp : timePeriods) {
      m1.put(tp.startTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), 1);
    }
    System.out.println("Количество дней: " + m1.size());

    String a1 = "01/10/2021";
    MyDateFormat myDateFormat = new MyDateFormat();
    Date dateString = myDateFormat.getDateFromString(a1);
    System.out.println("Нормализованная дата 1: " + dateString);
    a1 = "13.10.2021";
    dateString = myDateFormat.getDateFromString(a1);
    System.out.println("Нормализованная дата 2: " + dateString);
    a1 = "2021-02-13";
    dateString = myDateFormat.getDateFromString(a1);
    System.out.println("Нормализованная дата 3: " + dateString);
    a1 = "3033-33-33";
    dateString = myDateFormat.getDateFromString(a1);
    System.out.println("Тестовая дата 4: " + dateString);

    a1 = "Sat Aug 16 00:00:00 MSK 1969";
    String parseFormat = "EEE MMM d HH:mm:ss z yyyy";
    TimeZone timeZone = TimeZone.getTimeZone("MSK");
    DateFormat format = new SimpleDateFormat(parseFormat);
    format.setTimeZone(timeZone);
    Date d1 = format.parse(a1);
    System.out.println("Тестовая дата 5: " + d1);

    getMonthDays(new Date().getTime());

  }

  public static void getMonthDays(Long date) {
    if (date != null) {
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      calendar.setTime(new Date(date));
      calendar.set(Calendar.DAY_OF_MONTH, 1);
      Date dateFrom = new Date(calendar.getTimeInMillis());
      calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
      Date dateTo = new Date(calendar.getTimeInMillis());
      System.out.println("Первый день месяца: " + dateFrom);
      System.out.println("Последний день месяца: " + dateTo);
    }

  }

  @Override
  public String toString() {
    return "TimePeriod{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
  }
}
