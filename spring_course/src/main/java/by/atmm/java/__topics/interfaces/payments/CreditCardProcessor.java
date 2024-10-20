package by.atmm.java.__topics.interfaces.payments;

public class CreditCardProcessor implements PaymentProcessor {

  @Override
  public void processPayment(double amount) {
    System.out.println("Credit card payment of $: " + amount);
  }
}
