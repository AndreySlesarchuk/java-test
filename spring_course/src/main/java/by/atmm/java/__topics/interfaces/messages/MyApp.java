package by.atmm.java.__topics.interfaces.messages;

public class MyApp {
  private MessageService messageService;

  // Constructor injection
  public MyApp(MessageService service) {
    this.messageService = service;
  }

  public void processMessages(String message) {
    messageService.sendMessage(message);
  }
}
