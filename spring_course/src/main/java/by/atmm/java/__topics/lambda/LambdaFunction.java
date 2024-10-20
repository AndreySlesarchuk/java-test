package by.atmm.java.__topics.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaFunction {

  public static void main(String[] args) {
    List<String> names = Arrays.asList("John", "Jane", "Doe", "Sarah");

//    Collections.sort(names, (String a, String b) -> a.length() - b.length());
//    Collections.sort(names, Comparator.comparingInt(String::length));
    names.sort(Comparator.comparingInt(String::length));
    names.forEach(System.out::println);
    Integer a = 10;
  }
}
