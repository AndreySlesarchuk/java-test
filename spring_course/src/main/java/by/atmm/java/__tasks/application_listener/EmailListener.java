package by.atmm.java.__tasks.application_listener;

import org.springframework.context.ApplicationListener;

public class EmailListener implements ApplicationListener<EmailEvent> {

    @Override
    public void onApplicationEvent(EmailEvent emailEvent) {
        emailEvent.print();
        System.out.println("the source is:" + emailEvent.getSource());
        System.out.println("the address is:" + emailEvent.address);
        System.out.println("the email's context is:" + emailEvent.text);
    }
}
