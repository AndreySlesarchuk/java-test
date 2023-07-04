package by.atmm.java.__tasks.behavioral.template.authorization;
/**
 * Created by Andrey Slesarchuk on 06/21/2020.
 */
public class LoginException extends Exception {
  public LoginException(String message, Throwable cause) {
    super(message, cause);
  }

  public LoginException(Throwable cause) {
    super(cause);
  }
}
