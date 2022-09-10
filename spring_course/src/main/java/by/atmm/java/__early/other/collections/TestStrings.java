package by.atmm.java.__early.other.collections;

public class TestStrings {

  public static void main(String[] args) {
    TestStrings ts = new TestStrings();
    String states = "Германия  Франция    Италия    Испания";
    String res = ts.removeSpaces(states);
    System.out.println(res);

    String[] arrayList = new String[] {"Германия", "Франция", "Италия", "Испания"};
    StringBuilder line = new StringBuilder();
    String splitter = "#";
    for(int i = 0; i < arrayList.length; i++) {
      line.append(arrayList[i]);
      line.append(splitter);
    }
    String resultStr = line.toString();
    String[] resultArr = resultStr.split(splitter);
    System.out.println(resultStr);
    System.out.println(resultArr);

    String doubleString = "1348.0";
    String integerString = doubleString.substring(0, doubleString.length() - 2);
    System.out.println("Integer number is: " + integerString);

    Double d = Double.valueOf(doubleString);
    int i = d.intValue();
    System.out.println("Integer from double: " + i);

    String smsText = "Вы записаны в \"Парикмахерская Мужская Территория\" на Мужская стрижка. 27.08.2021 в 16.00. https://clck.ru/X7rfx";
    System.out.println(ts.getSmsServiceText(smsText, false));
    smsText = "Вы записаны в \"Неовит \" на Комплексное исследование малого таза трансвагинально,лимфатич.узлы,дупл.скан.. 01.09.2021 в 11.00";
    smsText = "Вы записаны в \"Неовит \" на Вакуум-мини-аборт (Комплексная процедура) . 31.08.2021 в 09.30";
    System.out.println(ts.getSmsServiceText(smsText, false));
  }

  private String getSmsServiceText(String smsText, boolean isSendService) {
    if (isSendService) return smsText;
    String fromString = " на ";
    String toString = ". ";
    int indexFrom = smsText.indexOf(fromString);
    return new StringBuilder(smsText).delete(smsText.indexOf(fromString), smsText.indexOf(toString, indexFrom)).toString();
  }

  private String removeSpaces(String str) {
    if (str.indexOf("  ") != -1) {
      return removeSpaces(str.replace("  ", " "));
    }
    return str;
  }

}
