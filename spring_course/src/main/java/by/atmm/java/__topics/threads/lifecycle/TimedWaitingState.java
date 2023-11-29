package by.atmm.java.__topics.threads.lifecycle;

public class TimedWaitingState {
  public static void main(String[] args) throws InterruptedException {
    DemoTimeWaitingRunnable runnable= new DemoTimeWaitingRunnable();
    Thread t1 = new Thread(runnable);
    t1.start();
    Thread.sleep(1000);
    System.out.println(t1.getState());
  }
}

class DemoTimeWaitingRunnable implements Runnable {
  @Override
  public void run() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
  }
}