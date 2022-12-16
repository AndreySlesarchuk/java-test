package by.atmm.java.__early.__topics.collections;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class AggregateOperations {

    public static void main(String[] args) {

        BinaryOperator<Integer> myTest1 = (a, b) -> a*2+b*3;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int resultReduce = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println("Base array: " + numbers + " resultReduce: " + resultReduce); // 21

        int resultReduceInteger = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Base array: " + numbers + " resultReduceInteger: " + resultReduceInteger); // 21

        int resultReduceMyTest1 = numbers.stream().reduce(0, myTest1);
        System.out.println("Base array: " + numbers + " resultReduceMyTest1: " + resultReduceMyTest1); // 360

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String resultReduceLetters = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);
        System.out.println("Base array: " + letters + " resultReduceLetters: " + resultReduceLetters); // "abcde"


        List<Employee> employees = List.of(new Employee("A", 3500, 23), new Employee("B", 2000, 30));
        //employees.stream().reduce(B)
    }



}

@Data
class Employee {
    private  String name;
    private Integer salaryInt;
    private Integer age;

    public Employee(String a, int i, int i1) {
        name = a;
        salaryInt = i;
        age = i1;
    }
}