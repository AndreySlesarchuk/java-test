package by.atmm.java.__early.initializer.static_class;

//      What is the output of the above code?
//        Compilation error         36%
//        NullPointerException      39%
//        Hello World               22%
//        World World                3%

//  Hello World is the output as static methods are bonded at compile time and hence cannot be overridden.
//  The method overriding relies on dynamic binding during runtime.
//  Good question anyway.

public class StaticClassTest {

    static class B {
        static String getText() {
            return "Hello";
        }
    }

    static class A extends B {
        static String getText() {
            return "World";
        }
    }

    public static void main(String... args) {
        B i = new A();
        A a = null;
        System.out.println(i.getText() + " " + a.getText());
    }

}

