package by.atmm.java.__topics.interfaces.messages;

public class SmsService implements MessageService {
  @Override
  public void sendMessage(String message) {
    System.out.println("Sms message: " + message);
  }
}
