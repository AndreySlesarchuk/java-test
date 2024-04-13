package by.atmm.java.__topics.threads;

public class RunnableErrorTest implements Runnable
{
  public void run()
  {
    System.out.printf("Test");
  }
  public static void main(String[] args) throws InterruptedException
  {
    Thread thread1 = new Thread(new RunnableErrorTest());
    thread1.start();
    thread1.start(); // Runtime exception
    System.out.println(thread1.getState());
  }
}