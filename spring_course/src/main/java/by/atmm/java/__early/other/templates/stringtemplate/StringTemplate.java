package by.atmm.java.__early.other.templates.stringtemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Slesarchuk on 10/19/2020.
 */

public class StringTemplate {

  static Logger log = Logger.getLogger(String.valueOf(StringTemplate.class));

  private static final String SMS_TEMPLATE = "Уважаемый ${user.name}! Ваш заказ будет доставлен по адресу ${user.address}. ${date}";

  public static void main(String[] args) {
    Map<String, String> valuesMap = new HashMap<>();
    valuesMap.put("user.name", "Николай Петрович");
    valuesMap.put("user.address", "Минск, Волгоградская улица, дом 52");
    valuesMap.put("date", "22 октября 2020 в 19:00");
    by.atmm.java.__early.other.templates.stringtemplate.StrSubstitutor sub = new by.atmm.java.__early.other.templates.stringtemplate.StrSubstitutor(valuesMap);
    String resolvedString = sub.replace(SMS_TEMPLATE);
    log.info(resolvedString);
  }
}
