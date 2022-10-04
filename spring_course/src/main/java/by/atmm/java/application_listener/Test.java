package by.atmm.java.application_listener;

public class Test {
    public static void main(String[] args) {

        EmailEvent event = new EmailEvent("hello", "boylmx@163.com", "this is a email text!");
        System.out.println(event);
        System.out.println("Timestamp: " + event.getTimestamp());
        System.out.println(event.getClass());

    }
}