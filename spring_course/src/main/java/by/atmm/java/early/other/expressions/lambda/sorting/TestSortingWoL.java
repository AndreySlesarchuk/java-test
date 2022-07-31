package by.atmm.java.early.other.expressions.lambda.sorting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Slesarchuk on 11/04/2020.
 */
public class TestSortingWoL {
  public static void main(String[] args) {

    List<Developer> listDevs = getDevelopers();

    System.out.println("Before Sort");
    for (Developer developer : listDevs) {
      System.out.println(developer);
    }

    System.out.println("After Sort");

    // lambda here!
    listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());

    // java 8 only, lambda also, to print the List
    listDevs.forEach((developer) -> System.out.println(developer));
  }

  private static List<Developer> getDevelopers() {

    List<Developer> result = new ArrayList<>();

    result.add(new Developer("mike", new BigDecimal("70000"), 33));
    result.add(new Developer("alan", new BigDecimal("80000"), 20));
    result.add(new Developer("jakie", new BigDecimal("100000"), 10));
    result.add(new Developer("dan", new BigDecimal("170000"), 55));

    return result;

  }

}
