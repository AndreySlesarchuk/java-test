package by.atmm.java.early.tregulov_alishev.regex;

public class Regex4 {
    public static void main(String[] args) {
        String s = "He    difficult   contented we determine ourselves me am earnestly     14";
        System.out.println(s);

        //s = s.replaceAll(" {2,}", " ");
        s = s.replaceAll(" \\s+", " ");
        System.out.println(s);
    }

}
