package by.atmm.java.early.treali.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest {
    public static void main(String[] args) {
        String text = "He difficult contented we determine ourselves me am earnestly. "
                + "Hour no find it park. Eat welcomed any husbands moderate. "
                + "Led was misery played waited almost cousin living 3237573@gmail.coma. "
                + "Of intention contained is by dan7@list.ru middleton am. "
                + "Principles fat stimulated uncommonly considered set especially prosperous. "
                + "Sons at park mr meet as fact like.";

        Pattern email = Pattern.compile("(\\w+)@(gmail|list)\\.(\\w{2,3})");
        Matcher matcher = email.matcher(text);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
