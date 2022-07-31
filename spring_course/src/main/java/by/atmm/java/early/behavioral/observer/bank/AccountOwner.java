package by.atmm.java.early.behavioral.observer.bank;
/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public class AccountOwner implements Observer {

  private String name;

  public AccountOwner(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override public void update(Subject subject) {
    if (subject instanceof Account) {
      Account account = (Account) subject;
      System.out.println(name + "'s balance changed : " + account.getAmount());
    }
  }

}
