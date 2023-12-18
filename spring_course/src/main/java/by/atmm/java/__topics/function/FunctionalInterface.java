package by.atmm.java.__topics.function;

public class FunctionalInterface {

  public static void main(String[] args) {
    MyFunction addition = (a, b) -> a + b;
    MyFunction substraction = (a, b) -> a - b;

    int result1 = addition.apply(2, 5);
    int result2 = substraction.apply(5,3);

    System.out.println("Result1: " + result1);
    System.out.println("Result2: " + result2);
  }

}

interface MyFunction {
  int apply(int a, int b);
}
