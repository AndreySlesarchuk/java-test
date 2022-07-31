package by.atmm.java.early.behavioral.observer.chat;

import java.util.logging.Logger;

/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public class Admin implements ChatObserver {
  private static final Logger LOGGER = Logger.getLogger(Admin.class.getName());

  @Override
  public void update(String message) {
    LOGGER.info(String.format("%s get new message: %s", this.getClass().getName(), message));
  }
}
