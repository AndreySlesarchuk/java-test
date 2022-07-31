package by.atmm.java.early.tregulov_alishev.regex;

public class ExpressionTest {

    public static void main(String[] args) {
        /*
            https://regexlib.com/CheatSheet.aspx

            \\d - одна цифра
            \\w -   одна буква
            + - 1 или более
            * - 0 или более
            ? - 0 или 1 символов до a.matches("-?\\d*") минус может быть а может и не быть - ДО

            ( x|y|a ) - одна строка из множества строк

            [abc] = (a|b|c) - spaces is important
            [a-zA-Z] - множества - все различные буквы
            [0-9] = \\d
            [^abc] - мы хотим все символы кроме [abc]

            .   - любой символ
            {2}  - цифры в фигурных скобках, конкретное конкретное количество чисел ДО (\\d{2}
            {2, }  - два или более чисел ДО (\\d{2б}
            {2,4}  - от двух до 4 чисел ДО

         */
        String a = "-1111";
        String b = "1111";
        String c = "+1111";

        System.out.println(a.matches("(-|\\+)?\\d*"));
        System.out.println(b.matches("(-|\\+)?\\d*"));
        System.out.println(c.matches("(-|\\+)?\\d*"));

        String d = "a12345";
        System.out.println(d.matches("[a-zA-Z]*\\d*"));

        String e = "hello12345";
        System.out.println(e.matches("[^a-cA-C]*\\d*"));

        String url = "https://www.google.com";
        String url2 = "https://www.yahoo..org";
        System.out.println(url.matches("https://www\\..+\\.(com|org)"));
        System.out.println(url2.matches("https://www\\..+\\.(com|org)"));

        String f = "12345";
        System.out.println(f.matches("\\d{2,5}"));

    }
}
