package by.atmm.java.__topics.templates;

public class SwitchInJava17 {

  public static void main(String[] args) {
    System.out.println("Test01: ".concat(test01("B")));
    System.out.println("Test02: ".concat(test02("13").toString()));
    System.out.println("Test03: ".concat(test03(Number.TWO)));
  }

  public enum Number {
    ONE, TWO, THREE, FOUR;
  }

  public static String test01(String str) {
    final String b = "B";
    return switch (str) {
      case "A" -> "Parameter is A";
      case b -> "Parameter is b";
      default -> "Parameter is unknown";
    };
  }

  public static Double test02(Object obj) {
    return switch (obj) {
      case Integer i -> i.doubleValue();
      case Float f -> f.doubleValue();
      case String s -> Double.parseDouble(s);
      default -> 0d;
    };
  }

  // Since Java 14, the yield keyword within switch expressions gives us a better approach.
  // https://www.baeldung.com/java-yield-switch
  public static String test03(Number number) {
    return switch (number) {
      case ONE:
        yield "Got a 1";
      case TWO:
        yield "Got a 2";
      default:
        yield "More than 2";
    };
  }

}
