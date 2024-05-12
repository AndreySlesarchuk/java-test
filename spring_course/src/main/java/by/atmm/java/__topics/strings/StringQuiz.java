package by.atmm.java.__topics.strings;

import java.lang.instrument.Instrumentation;

public class StringQuiz {

    public static void main(String[] args) {

        Instrumentation globalInstrumentation = null;

        String[] elements = {"for", "tea", "too"};
        String first = (elements.length > 0) ? elements[0] : null;
        System.out.println(first);

        String str = "420";
        str += 42;
        System.out.println(str);

        String icd = "Острый нефритич.синдром.Диффузн.мезангиальн.пролиферативный гломерулонефрит\n";
        System.out.println(icd.length());
        System.out.println(globalInstrumentation.getObjectSize(icd));
    }
}
