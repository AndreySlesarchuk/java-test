package by.atmm.java.application_listener;

import java.util.Date;

public class Test {
    public static void main(String[] args) {

        EmailEvent event = new EmailEvent(new Date(), "boylmx@163.com", "this is a email text!");
        System.out.println(event);
        System.out.println("Timestamp: " + event.getTimestamp());
        System.out.println(event.getClass());

    }
}