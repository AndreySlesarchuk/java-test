package by.atmm.__gof.behavioral.observer.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public class Account implements Subject{

  private final List<Observer> observers = new ArrayList<>();
  private final AccountOwner accountOwner;
  private final String accountNumber;

  private int amount;

  public Account(AccountOwner accountOwner, String accountNumber) {
    this.accountOwner = accountOwner;
    this.accountNumber = accountNumber;
    register(accountOwner);
  }

  public AccountOwner getAccountOwner() {
    return accountOwner;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public int getAmount() {
    return amount;
  }

  public void deposit(int amount) {
    this.amount += amount;
    notifyObservers();
  }

  public void withdraw(int amount) {
    this.amount -= amount;
    notifyObservers();
  }

  @Override public void register(Observer observer) {
    observers.add(observer);
  }

  @Override public void unregister(Observer observer) {
    observers.remove(observer);
  }

  @Override public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(this);
    }
  }
}
