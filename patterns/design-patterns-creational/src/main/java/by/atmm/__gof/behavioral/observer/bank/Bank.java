package by.atmm.__gof.behavioral.observer.bank;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mike Ramanovich, Andrey Slesarchuk on 07/26/2020.
 */
public class Bank {
  private static int accountNumberCounter;

  private final Map<String, Account> accounts = new HashMap<String, Account>();

  private final Government government = new Government();

  public String addAccount(String accountOwnerName) {
    AccountOwner accountOwner = new AccountOwner(accountOwnerName);
    Account account = new Account(accountOwner, "account" + accountNumberCounter++);
    account.register(government);
    accounts.put(account.getAccountNumber(), account);
    return account.getAccountNumber();
  }

  public void depositAmount(String accountNumber, int amount) {
    Account account = accounts.get(accountNumber);
    account.deposit(amount);
  }

  public void withdrawAmount(String accountNumber, int amount) {
    Account account = accounts.get(accountNumber);
    account.withdraw(amount);
  }

}
