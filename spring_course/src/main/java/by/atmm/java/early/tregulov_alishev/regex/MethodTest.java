package by.atmm.java.early.tregulov_alishev.regex;

import java.util.Arrays;

public class MethodTest {

    public static void main(String[] args) {

        String a = "Hello12my34555world";
        String[] words = a.split("\\d+");
        System.out.println(Arrays.toString(words));

        String b = "Hello my  world";
        String modifiedString = b.replace(" ", ".");
        System.out.println(modifiedString);

        String c = "Hello2222222222333333my5555555555world";
        String modified1String = c.replaceAll("\\d+", "-");
        System.out.println(modified1String);
        String modified2String = c.replaceFirst("\\d+", "-");
        System.out.println(modified2String);
    }
}
