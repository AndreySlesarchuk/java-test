package by.atmm.java.__tasks.behavioral.template.authorization;

/**
 * Created by Andrey Slesarchuk on 06/21/2020.
 */
public abstract class Login {
  public final LoginResult login() throws LoginException {
    Credential credential = fetchCredentials();
    logCredential(credential);
    LoginResult loginResult = authenticate(credential);
    logAuthentication(loginResult);
    postAuthentication(loginResult);
    return loginResult;
  }

  private void logAuthentication(LoginResult loginResult) {
    System.out.println("login result : " + loginResult);
  }

  private void logCredential(Credential credential) {
    System.out.println("login : " + credential.getLoginName());
  }

  protected abstract void postAuthentication(LoginResult loginResult);

  protected abstract LoginResult authenticate(Credential credential) throws LoginException;

  protected abstract Credential fetchCredentials();
}
