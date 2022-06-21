package by.atmm.javaspringtestproject.jmm;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-21
 *
 *  https://youtu.be/7IkpIQc8OCw
 */


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        String last = "Z";
        Container container = new Container();
        container.setInitial("C");
        another(container, last);
        System.out.println(container.getInitial());
    }

    public void another(Container initialHolder, String newInitial) {
        newInitial.toLowerCase();
        initialHolder.setInitial("B");
        Container initial2 = new Container();
        initialHolder = initial2;
        System.out.println(initialHolder.getInitial());
        System.out.println(newInitial);
    }
}
