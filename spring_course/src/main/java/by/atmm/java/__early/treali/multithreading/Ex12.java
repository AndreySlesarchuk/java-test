package by.atmm.java.__early.treali.multithreading;

public class Ex12 {

  static final Object lock = new Object();

  void mobileCall() {
    synchronized (lock) {
      System.out.println("Mobile call start");
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Mobile call ends");
    }
  }

  void skypeCall() {
    synchronized (lock) {
      System.out.println("Skype call start");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Skype call ends");
    }
  }

  void telegramCall() {
    synchronized (lock) {
      System.out.println("Telegram call start");
      try {
        Thread.sleep(7000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Telegram call ends");
    }
  }

  public static void main(String[] args) {
    Thread thread1 = new Thread(new RunnableImplMobile());
    Thread thread2 = new Thread(new RunnableImplSkype());
    Thread thread3 = new Thread(new RunnableImplTelegram());

    thread1.start();
    thread2.start();
    thread3.start();
  }

}

class RunnableImplMobile implements Runnable {

  public void run() {
    new Ex12().mobileCall();
  }
}

class RunnableImplSkype implements Runnable {

  public void run() {
    new Ex12().skypeCall();
  }
}

class RunnableImplTelegram implements Runnable {

  public void run() {
    new Ex12().telegramCall();
  }
}