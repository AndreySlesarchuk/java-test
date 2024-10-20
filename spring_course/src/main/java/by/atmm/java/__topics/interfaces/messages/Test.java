package by.atmm.java.__topics.interfaces.messages;

public class Test {

  public static void main(String[] args) {
    var serviceEmail = new EmailService();
    var serviceSms = new SmsService();

    MyApp myApp = new MyApp(serviceEmail);
    myApp.processMessages("Hello World!");

    myApp = new MyApp(serviceSms);
    myApp.processMessages("Hello World!");

  }

}
