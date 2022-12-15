package by.atmm.java.__early.__topics.exceptions;

public class TestFinally {
  static void methodA() {
    try {
      System.out.println("inside methodA");
      throw new RuntimeException("Exception in methodA");
    }
    finally {
      System.out.println("finally inside methodA");
    }
  }

  static void methodB() {
    try {
      System.out.println("inside methodB");
      return;
    }
    finally {
      System.out.println("finally inside methodB");
    }
  }

  public static void main(String args[]) {
    try {
      methodA();
    }
    catch (Exception e) {
      System.out.println("Catch exception inside main");
    }
    methodB();
  }
}