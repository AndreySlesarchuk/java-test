package by.atmm.__gof.behavioral.template.authorization;

/**
 * Created by Andrey Slesarchuk on 06/27/2020.
 */
public class PasswordUser extends User {
  private String passwordDigest;

  private int salt;

  public PasswordUser(String userId) {
    super(userId);
  }

  public String getPasswordDigest() {
    return passwordDigest;
  }

  public void setPasswordDigest(String passwordDigest) {
    this.passwordDigest = passwordDigest;
  }

  public int getSalt() {
    return salt;
  }

  public void setSalt(int salt) {
    this.salt = salt;
  }
}
