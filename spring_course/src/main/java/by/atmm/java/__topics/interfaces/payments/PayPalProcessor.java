package by.atmm.java.__topics.interfaces.payments;

public class PayPalProcessor implements PaymentProcessor {

  @Override
  public void processPayment(double amount) {
    System.out.println("PayPal payment of $: " + amount);
  }
}
