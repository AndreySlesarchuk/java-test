package by.atmm.gof.behavioral.template.beverage;

/**
 * Created by Andrey Slesarchuk on 06/19/2020.
 */
abstract class Beverage {

  public void makeBeverage() {
    startHook();
    boilWater();
    addBeverage();
    addSugar();
    addConditment();
    endHook();
  }

  void startHook() {
  }

  void endHook() {
  }

  private void boilWater() {
    System.out.println("boiled water");
  }

  private void addSugar() {
    System.out.println("add sugar");
  }

  abstract void addBeverage();

  abstract void addConditment();

}
