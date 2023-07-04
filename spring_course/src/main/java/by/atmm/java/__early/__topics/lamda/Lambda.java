package by.atmm.java.__early.__topics.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//        Java Developers Community. Follow Deepak Gupta for more such content.
//        What will be the output of the following code?
//        1, 3, 5
//        8%
//        2, 4
//        55%
//        1, 2, 3, 4, 5
//        12%
//        None of the above
//        26%
//        490 votes


public class Lambda {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

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
