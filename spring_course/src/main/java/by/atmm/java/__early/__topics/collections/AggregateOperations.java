package by.atmm.java.__early.__topics.collections;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class AggregateOperations {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int resultReduce = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println("Base array: " + numbers + " resultReduce: " + resultReduce); // 21


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