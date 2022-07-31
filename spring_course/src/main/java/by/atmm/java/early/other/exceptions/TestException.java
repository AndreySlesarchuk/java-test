package by.atmm.java.early.other.exceptions;

public class TestException {
  public static void main(String[] args) {
    try {
      System.err.print("level 0");
      throw new RuntimeException();
      //System.err.print("level 1");
    }
    catch (Exception e) {
      // catch Exception ПЕРЕХВАТ RuntimeException
      System.err.print("level 2");
    }
    System.err.println("level 3");
  }
}