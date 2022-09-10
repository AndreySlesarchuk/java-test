package by.atmm.java.__early.other.expressions.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by Andrey Slesarchuk on 10/19/2020.
 */
public class MyConsumer {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(5);
    numbers.add(9);
    numbers.add(8);
    numbers.add(1);
    Consumer<Integer> method = (n) -> {
      System.out.println(n);
    };
    numbers.forEach(method);
  }
}