package by.atmm.java.__early.treali.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
    public static void main(String[] args) {
        String s = "He difficult contented we determine ourselves me am earnestly. 14 "
                + "Hour no find it park. Eat welcomed  any husbands moderate. 345 "
                + "Led was misery played waited almost cousin living 3237573@gmail.coma.  25 "
                + "Of intention contained is by dan7@list.ru middleton am. "
                + "Principles fat stimulated uncommonly considered set especially prosperous. "
                + "Sons at park mr meet as fact like. +375293237573";

//        Pattern email = Pattern.compile("(\\w+)@(gmail|list)\\.(\\w{2,3})");
//        Pattern pattern = Pattern.compile("(\\b\\d{2}\\b)"); // \b границы слова
//        Pattern pattern = Pattern.compile("\\+\\d{12}"); // телефон
//        Pattern pattern = Pattern.compile("(\\w+)@\\w+\\.(\\w{2,3})");
//        Pattern pattern = Pattern.compile("(\\w\\s+\\w)"); // space [\t\n\r\f]
        s ="ABC ABC ABD ABE ";
        Pattern pattern = Pattern.compile("(\\w+){2,}");
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()) {
            System.out.println("Position: " + matcher.start() + " " + matcher.group());
        }
    }

}
