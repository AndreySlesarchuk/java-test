package by.atmm.java.__topics.java8.function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andrey Slesarchuk on 11/01/2020.
 */
public class MyNumbers {

  public interface Function<F, T> {
    T apply(F from);
  }

  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(2);
    numbers.add(7);
    numbers.add(9);
    numbers.add(1);
    MyNumbers myNumbers = new MyNumbers();

    System.out.println(myNumbers.joinNumbers(numbers));

    System.out.println(myNumbers.joinNumbersF(numbers));

  }

  Function<Integer, String> intToString = new Function<Integer, String>() {
    @Override
    public String apply(Integer from) {
      return from.toString();
    }
  };

  public String joinNumbers(Collection<? extends Integer> numbers) {
    StringBuilder result = new StringBuilder();
    boolean first = true;
    for (Integer number : numbers) {
      if (first)
        first = false;
      else
        result.append(", ");
      result.append(number);
    }
    return result.toString();
  }

  public String joinNumbersF(Collection<? extends Integer> numbers) {
    return join(map(numbers, intToString), "|");
  }

  public static <F, T> List<T> map(Collection<F> from, Function<? super F, ? extends T> transformer) {
    ArrayList<T> result = new ArrayList<T>();
    for (F element : from)
      result.add(transformer.apply(element));
    return result;
  }

  public static <T> String join(Collection<T> from, String separator) {
    StringBuilder result = new StringBuilder();
    boolean first = true;
    for (T element : from) {
      if (first)
        first = false;
      else
        result.append(separator);
      result.append(element);
    }
    return result.toString();
  }

}
