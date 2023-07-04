package by.atmm.java.__tasks.__topics.lambda;

import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Created by Slesarchuk on 10/19/2020.
 */

public class MyNumber {

    static Logger log = Logger.getLogger(String.valueOf(MyNumber.class));

    public static void main(String[] args) {
        Consumer<Object> myMethod = n -> {
            if (n instanceof Integer) {
                log.fine("And this number - {}" + n + "!");
            } else {
                log.fine("Hello Word and " + n + "!");
            }
        };

        ExpNumber myNumber1 = (i, t) -> {
            int a;
            if (i < t)
                a = i;
            else
                a = t;
            return a;
        };

        myMethod.accept(myNumber1.someNum(2, -3));

        ExpNumber myNumber2 = (i, t) -> i * 10;
        myMethod.accept(myNumber2.someNum(5, 10));

        myMethod.accept("All");
    }
}

interface ExpNumber {
    int someNum(int i, int t);
}