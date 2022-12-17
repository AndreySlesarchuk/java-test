package by.atmm.java.__early.__topics.collections;

import by.atmm.java.__early.__topics.utils.Watch;

public class IntegerToString {

  public static void main(String[] args) {

    Watch watch = new Watch();
    Integer number = 1_234_567_890;
    int digitNumber = 1;
    watch.start();
    System.out.println("First - " + getDigitNumber(number, digitNumber));
    watch.totalTime("First time = ");
    watch.start();
    System.out.println("Second - " + String.valueOf(number).length());
    watch.totalTime("Second time = ");

  }

  private static Integer getDigitNumber(Integer num, int digitNumber) {
    if (num / 10 > 1) {
      Integer i = num / 10;
      int d = digitNumber + 1;
      return getDigitNumber(i, d);
    }
    return digitNumber + 1;
  }


}
