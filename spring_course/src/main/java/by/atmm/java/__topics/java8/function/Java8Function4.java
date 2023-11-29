package by.atmm.java.__topics.java8.function;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Andrey Slesarchuk on 10/31/2020.
 */
public class Java8Function4 {

  public static void main(String[] args) {

    Java8Function4 obj = new Java8Function4();

    List<String> list = Arrays.asList("node", "c++", "java", "javascript");

    // lambda
    // List<String> result = obj.map(list, x -> obj.sha256(x));

    // method reference
    List<String> result = obj.map(list, obj::sha256);

    result.forEach(System.out::println);

  }

  public <T, R> List<R> map(List<T> list, Function<T, R> func) {
    List<R> result = new ArrayList<>();
    for (T t : list) {
      result.add(func.apply(t));
    }
    return result;

  }

  // sha256 a string
  public String sha256(String str) {
    return DigestUtils.sha256Hex(str);
  }
}
