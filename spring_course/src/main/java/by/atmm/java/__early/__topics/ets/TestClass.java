package by.atmm.java.__early.__topics.ets;

public class TestClass {
  public static int getSwitch(String str) {
    return (int) Math.round(Double.parseDouble(str.substring(1, str.length() - 1)));
  }

  public static void main(String args[]) {
    String t1 = "--0.50";
    int t2 = getSwitch(t1);
    switch (t2) {
      case 0:
        System.out.print("Hello ");
      case 1:
        System.out.print("World");
        break;
      default:
        System.out.print("Good Bye");
    }
  }
}
