package by.atmm.java.__early.__topics.collections;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class AggregateOperations {

  public static void main(String[] args) {

    List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
    int computedAges = ages.parallelStream().reduce(0, (a, b) -> a + b, Integer::sum);
    System.out.println("Base array: " + ages + " computedAges: " + computedAges); // 21

    List<User> users = Arrays.asList(
        new User("John", 30, BigDecimal.valueOf(500.50)),
        new User("Julie", 35, BigDecimal.valueOf(700.70)));
    BigDecimal computedSalary = users
        .stream().map(User::getSalary)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println("Base array: " + users + " computedSalary: " + computedSalary); // 21

    BinaryOperator<Integer> myTest1 = (a, b) -> a * 2 + b * 3;

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int resultReduce = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);
    System.out.println("Base array: " + numbers + " resultReduce: " + resultReduce); // 21

    int resultReduceInteger = numbers.stream().reduce(0, Integer::sum);
    System.out.println(
        "Base array: " + numbers + " resultReduceInteger: " + resultReduceInteger); // 21

    int resultReduceMyTest1 = numbers.stream().reduce(0, myTest1);
    System.out.println(
        "Base array: " + numbers + " resultReduceMyTest1: " + resultReduceMyTest1); // 360

    List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
    String resultReduceLetters = letters.stream()
        .reduce("", (partialString, element) -> partialString + element);
    System.out.println(
        "Base array: " + letters + " resultReduceLetters: " + resultReduceLetters); // "abcde"

    String resultReduceUpper = letters.stream().reduce("",
        (partialString, element) -> partialString.toUpperCase() + element.toUpperCase());
    System.out.println(
        "Base array: " + letters + " resultReduceUpper: " + resultReduceUpper); // "abcde"

    List<Employee> employees = List.of(new Employee("A", 3500, 23), new Employee("B", 2000, 30));

  }
}

@Data
class User {

  private String name;
  private Integer age;
  private BigDecimal salary;

  public User(String name, Integer age, BigDecimal salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }
}

@Data
class Employee {

  private String name;
  private Integer salaryInt;
  private Integer age;

  public Employee(String a, int i, int i1) {
    name = a;
    salaryInt = i;
    age = i1;
  }
}