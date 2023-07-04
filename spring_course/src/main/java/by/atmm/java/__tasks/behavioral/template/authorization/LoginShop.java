package by.atmm.java.__tasks.behavioral.template.authorization;

/**
 * Created by Andrey Slesarchuk on 06/27/2020.
 */
public class LoginShop {
  public static void main(String[] args) {

    try {
      UserStorage.getInstance().initialize();
    }
    catch (UserStorageException e) {
      e.printStackTrace();
    }

    String login = "login1";
    String password = /* "wrong" + */"password1";

    PasswordLogin passwordLogin = new PasswordLogin(login, password);

    try {
      LoginResult loginResult = passwordLogin.login();
      System.out.println(loginResult);
    }
    catch (LoginException e) {
      e.printStackTrace();
    }
  }
}
