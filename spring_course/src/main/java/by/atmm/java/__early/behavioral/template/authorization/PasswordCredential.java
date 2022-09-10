package by.atmm.java.__early.behavioral.template.authorization;

/**
 * Created by Andrey Slesarchuk on 06/27/2020.
 */
public class PasswordCredential extends Credential {
  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
