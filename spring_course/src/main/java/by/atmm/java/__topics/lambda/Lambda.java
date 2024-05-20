package by.atmm.java.__topics.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lambda {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        Predicate<Integer> predicate = x -> {
            int count = 0;
            boolean result = false;
            while (count < 2) {
                if (x % 2 == 0) {
                    result = true;
                }
                count++;
            }
            return result;
        };

        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

}
