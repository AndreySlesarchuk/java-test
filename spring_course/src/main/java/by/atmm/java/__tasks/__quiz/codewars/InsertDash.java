package by.atmm.java.__tasks.__quiz.codewars;

public class InsertDash {

  public static String insertDash(int num) {
    StringBuilder sb = new StringBuilder(String.valueOf(num));
    if (sb.length() == 0) {
      return "";
    }
    StringBuilder result = new StringBuilder();
    result.append(sb.charAt(0));
    boolean previousIsOdd = ((Character.getNumericValue(sb.charAt(0)) & 1) != 0);
    for (int i = 1; i < sb.length(); i++) {
      if ((Character.getNumericValue(sb.charAt(i)) & 1) != 0) {
        if (previousIsOdd) {
          result.append('-');
        }
        previousIsOdd = true;
      } else {
        previousIsOdd = false;
      }
      result.append(sb.charAt(i));
    }
    return result.toString();
  }

  //public static String insertDash(int num) {
  //  return (num+"").replaceAll("([13579])(?=[13579])", "$1-");
  //}

}
