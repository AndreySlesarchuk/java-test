package by.atmm.java.early.behavioral.observer.bank;

/**
 * Created by Mike Ramanovich, Andrey Slesarchuk on 07/26/2020.
 */
public class App {
  public static void main(String[] args) {
    Bank bank = new Bank();
    String smithsAccountNumber = bank.addAccount("John Smith");
    String smirnovsAccountNumber = bank.addAccount("Ivan Smirnov");

    bank.depositAmount(smithsAccountNumber, 100);
    bank.depositAmount(smirnovsAccountNumber, 1000);

    bank.withdrawAmount(smithsAccountNumber, 99);
    bank.withdrawAmount(smirnovsAccountNumber, 999);

  }

}
