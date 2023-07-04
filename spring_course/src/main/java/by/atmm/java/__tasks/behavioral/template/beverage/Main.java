package by.atmm.java.__tasks.behavioral.template.beverage;

/**
 * Created by Andrey Slesarchuk on 06/19/2020.
 */
public class Main {
  public static void main(String[] args) {
    Beverage bevarage = new Coffee();
    bevarage.makeBeverage();
    bevarage = new Tea();
    bevarage.makeBeverage();
  }
}
