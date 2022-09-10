package by.atmm.java.__early.treali.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
        String s1 = "ABCD ABECE ABCFABC.GAB LKMEuE CH";

        //Pattern pattern1 = Pattern.compile("\\W{3}E");
        Pattern pattern1 = Pattern.compile("\\w+E\\w*E");
        Matcher matcher = pattern1.matcher(s1);

        while (matcher.find()) {
            System.out.println("Position: " + matcher.start() + " " + matcher.group());
        }
    }

}
