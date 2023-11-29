package by.atmm.java.__topics.threads.lifecycle;

import java.text.MessageFormat;

public class ThreadNewAndRunnableState implements Runnable {

  public static void main(String[] args) {
    Runnable runnable = new ThreadNewAndRunnableState();
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);
    thread1.start();
    System.out.println(MessageFormat.format("{0} : {1}", thread1.getName(), thread1.getState()));
    System.out.println(MessageFormat.format("{0} : {1}", thread2.getName(), thread2.getState()));
  }

  @Override public void run() {
    //
  }
}
