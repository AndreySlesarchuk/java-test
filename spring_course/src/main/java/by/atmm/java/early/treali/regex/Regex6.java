package by.atmm.java.early.treali.regex;

import java.util.regex.Pattern;

public class Regex6 {
    void checkIP(String ip) {
        String regex = "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}((25[0-5]|2[0-4]\\d|[01]?\\d?\\d))";
        //  25[0-5]     |   2[0-4]\d    |   [01]?d?\d   (\.)
        //  250-255     |   200-249     |   0-199
        System.out.println(ip + " is OK?:" + Pattern.matches(regex, ip));
    }

    public static void main(String[] args) {
        String ip1 = "255.49.27.8";
        String ip2 = "255.256.27.8";
        Regex6 regex6 = new Regex6();
        regex6.checkIP(ip1);
        regex6.checkIP(ip2);
    }

}