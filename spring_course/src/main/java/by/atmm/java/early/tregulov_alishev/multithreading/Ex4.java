package by.atmm.java.early.tregulov_alishev.multithreading;

public class Ex4 {
  public static void main(String[] args) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello");
      }
    }).start();

    new Thread(() -> System.out.println("Privet")).start();
  }
}
