package by.atmm.java.__topics.interfaces.payments;

public class Test {
  public static void main(String[] args) {
    PaymentProcessor ccProcessor = new CreditCardProcessor();
    PaymentProcessor ppProcessor = new PayPalProcessor();

    ccProcessor.processPayment(100d);
    ppProcessor.processPayment(200.00);

  }
}
