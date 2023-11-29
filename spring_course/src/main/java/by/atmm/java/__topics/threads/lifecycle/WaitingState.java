package by.atmm.java.__topics.threads.lifecycle;

public class WaitingState implements Runnable {
  public static Thread t1;

  public static void main(String[] args) {
    t1 = new Thread(new WaitingState());
    t1.start();

  }

  public void run() {
    Thread t2 = new Thread(new DemoWaitingStateRunnable());
    t2.start();
    System.out.println("Thread t2 state: " + t2.getState());
    try {
      t2.join();
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
  }
}

class DemoWaitingStateRunnable implements Runnable {
  public void run() {
    try {
      Thread.sleep(1000);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }

    System.out.println("Thread t1 state: " + WaitingState.t1.getState());
  }
}