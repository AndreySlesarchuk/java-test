package by.atmm.java.__tasks.__quiz.codewars;

import java.util.Collections;

public class Maskify {

  public static String maskify(String str) {
    if (str.length() < 5) {
      return str;
    }
    try {
      return String.join("", Collections.nCopies(str.length() - 4, "#")) + str.substring(
          str.length() - 4);
    } catch (UnsupportedOperationException e) {
      throw new UnsupportedOperationException("Unimplemented");
    }
  }

  public static String maskify2(String str) {
    return str.replaceAll(".(?=.{4})", "#");
  }

}
