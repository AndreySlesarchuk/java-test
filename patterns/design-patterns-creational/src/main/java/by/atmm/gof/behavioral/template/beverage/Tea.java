package by.atmm.gof.behavioral.template.beverage;

/**
 * Created by Andrey Slesarchuk on 06/19/2020.
 */
public class Tea extends Beverage {
  @Override
  void startHook() {
    System.out.println("throw boiling water");
  }

  @Override
  void addBeverage() {
    System.out.println("add tea");
  }

  @Override
  void addConditment() {
    System.out.println("add lemon");
  }
}
