package by.atmm.java.__tasks.treali.multithreading;

public class Ex10 {

  public static void main(String[] args) {
    MyRunnableImpl1 runnable = new MyRunnableImpl1();
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);
    Thread thread3 = new Thread(runnable);
    thread1.start();
    thread2.start();
    thread3.start();
  }

  Object a1 = new Object();
}

class Counter {

  static int count = 0;
}

class MyRunnableImpl1 implements Runnable {

  public synchronized void increment() {
    Counter.count++;
    System.out.print(Counter.count + " ");
  }

  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      increment();
    }
  }
}