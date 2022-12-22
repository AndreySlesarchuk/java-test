package by.atmm.java.__early.__quiz;

public class StringQuiz {

  public static void main(String[] args) {

    String[] elements = {"for", "tea", "too"};
    String first = (elements.length > 0) ? elements[0] : null;
    System.out.println(first);

    String str = "420";
    str += 42;
    System.out.println(str);
  }
}
