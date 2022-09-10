package by.atmm.java.__early.behavioral.observer.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public class Chat {
  private static final Logger LOGGER = Logger.getLogger(Chat.class.getName());

  private List messages;

  private List<ChatObserver> observers;

  public Chat() {
    observers = new ArrayList<>();
    messages = new ArrayList<>();
  }

  public void addObserver(ChatObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(ChatObserver observer) {
    observers.remove(observer);
  }

  public void addMessage(String message) {
    messages.add(message);
    LOGGER.info(String.format("Chat get new message: %s", message));
    notifyObservers(message);
  }

  private void notifyObservers(String message) {
    for (ChatObserver observer : observers) {
      observer.update(message);
    }
  }
}
