package by.atmm.java.__tasks.behavioral.template.authorization;

/**
 * Created by Andrey Slesarchuk on 06/20/2020.
 */
public class UserStorageException extends Exception {
  public UserStorageException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserStorageException(Throwable cause) {
    super(cause);
  }
}
