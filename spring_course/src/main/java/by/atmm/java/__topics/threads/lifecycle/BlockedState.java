package by.atmm.java.__topics.threads.lifecycle;

public class BlockedState {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new DemoBlockedRunnable());
    Thread t2 = new Thread(new DemoBlockedRunnable());

    t1.start();
    t2.start();

    Thread.sleep(1000);

    System.out.printf("Thread: %s : %s %n", t1.getName(), t1.getState());
    System.out.printf("Thread: %s : %s ", t2.getName(), t2.getState());
    System.exit(0);
  }
}

class DemoBlockedRunnable implements Runnable {
  @Override
  public void run() {
    commonResource();
  }

  public static synchronized void commonResource() {
    while(true) {

    }
  }
}