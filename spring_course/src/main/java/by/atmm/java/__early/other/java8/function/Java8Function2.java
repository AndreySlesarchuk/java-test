package by.atmm.java.__early.other.java8.function;

import java.util.function.Function;

/**
 * Created by Andrey Slesarchuk on 10/28/2020.
 */
public class Java8Function2 {
  public static void main(String[] args) {

    Function<String, Integer> func = x -> x.length();
    Integer applyResult = func.apply("java");
    Function<Integer, Integer> func2 = x -> x * 2;
    Integer result = func2.apply(applyResult); // 6
    System.out.println(result);

  }
}
