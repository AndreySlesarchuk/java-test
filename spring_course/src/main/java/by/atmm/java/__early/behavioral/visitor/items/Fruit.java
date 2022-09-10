package by.atmm.java.__early.behavioral.visitor.items;

/**
 * Created by Andrey Slesarchuk on 11/30/2020.
 */
public class Fruit implements ItemElement {

  private int pricePerKg;

  private int weight;

  private String name;

  public Fruit(int priceKg, int wt, String nm) {
    this.pricePerKg = priceKg;
    this.weight = wt;
    this.name = nm;
  }

  public int getPricePerKg() {
    return pricePerKg;
  }

  public int getWeight() {
    return weight;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public int accept(ShoppingCartVisitor visitor) {
    return visitor.visit(this);
  }

}