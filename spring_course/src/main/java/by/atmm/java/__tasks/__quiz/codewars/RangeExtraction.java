package by.atmm.java.__tasks.__quiz.codewars;

public class RangeExtraction {

  public static String solution(int[] arr) {
    if (arr.length == 0)
      return "";
    if (arr.length == 1)
      return String.valueOf(arr[0]);

    boolean flagOfRange = false;
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < arr.length - 1; i++) {
      if (isResultMoreThanOne(arr[i], arr[i + 1])) {
        result.append(arr[i]).append(",").append(arr[i+1]);
        flagOfRange = false;
      }
      else {
        if (!flagOfRange) {
          result.append("-");
          flagOfRange = true;
        }
      }
    }
    return result.toString();
  }

  public static boolean isResultMoreThanOne(int a1, int a2) {
    return (Math.abs(a1) - Math.abs(a2) != 1);
  }

}
