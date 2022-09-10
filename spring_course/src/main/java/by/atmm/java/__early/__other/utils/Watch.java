package by.atmm.java.__early.__other.utils;

/**
 * Created by Andrey Slesarchuk on 11/22/2020.
 */
public class Watch {
  private long startTime;

  private long endTime;

  public void start() {
    startTime = System.nanoTime();
  }

  private void stop() {
    endTime = System.nanoTime();
  }

  public void totalTime(String s) {
    stop();
    System.out.println(s + (endTime - startTime)); //Nanoseconds
    //System.out.println(s + ((endTime - startTime) / 1000000));// Milliseconds
  }
}
