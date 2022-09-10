package by.atmm.java.__early.__other.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Andrey Slesarchuk on 03/24/2021.
 */
public class MyDateFormat {

  public Date getDateFromString(String inputString) {
    String[] values = inputString.split("\\.");
    if (values.length == 3) {
      return getDateFromValues(new int[] { Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]) });
    }
    values = inputString.split("/");
    if (values.length == 3) {
      return getDateFromValues(new int[] { Integer.parseInt(values[1]), Integer.parseInt(values[0]), Integer.parseInt(values[2]) });
    }
    values = inputString.split("-");
    if (values.length == 3) {
      return getDateFromValues(new int[] { Integer.parseInt(values[2]), Integer.parseInt(values[1]), Integer.parseInt(values[0]) });
    }
    return null;
  }

  private Date getDateFromValues(int[] ints) {
    Calendar calendar = new GregorianCalendar(ints[2], ints[1] - 1, ints[0]);
    return calendar.getTime();
  }

}
