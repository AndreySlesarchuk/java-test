package by.atmm.java.__topics.templates;

public class Test {

  public static void main(String[] args) {
    int day = 1;
    String result = switch (day) {
      case 1 -> "Monday";
      case 2 -> "Tuesday";
      default -> "Unknown";
    };
    System.out.println(result);
  }

}
