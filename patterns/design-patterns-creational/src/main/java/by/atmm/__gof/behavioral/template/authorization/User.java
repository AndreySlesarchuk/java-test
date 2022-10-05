package by.atmm.__gof.behavioral.template.authorization;
/**
 * Created by Andrey Slesarchuk on 06/20/2020.
 */
public class User {

  private String userId;

  private String loginName;

  public User(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

}
