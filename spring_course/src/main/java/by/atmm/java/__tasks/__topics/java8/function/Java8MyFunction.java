package by.atmm.java.__tasks.__topics.java8.function;

import java.util.ArrayList;
import java.util.function.*;

/**
 * Created by Andrey Slesarchuk on 10/31/2020.
 */
public class Java8MyFunction {

  //public interface Function<F, T> {
  //  T apply(F from);
  //}

  public static void main(String[] args) {

    //Function<Integer, String> intToString = new Function<Integer, String>() {
    Function<Integer, String> intToString = from -> from.toString();
    System.out.println(intToString.apply(1024));

    // Predicate
    Predicate<Integer> isEvenNumber = x -> x % 2 == 0;

    System.out.println(isEvenNumber.test(4));
    System.out.println(isEvenNumber.test(3));

    // Consumer
    Consumer greetings = x -> System.out.println("Hello " + x + " !!!");
    greetings.accept("Elena");
    System.out.println(greetings);

    // Supplier
    ArrayList nameList = new ArrayList<>();
    nameList.add("Elena");
    nameList.add("Mike");
    nameList.add("Alan");
    nameList.add("Andrey");
    nameList.add("Tana");

    Supplier randomName = () -> {
      int value = (int) (Math.random() * nameList.size());
      return nameList.get(value);
    };
    System.out.println(randomName.get());

  }

}
