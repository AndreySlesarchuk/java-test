package by.atmm.java.__tasks.behavioral.visitor.items;

/**
 * Created by Andrey Slesarchuk on 11/30/2020.
 */
public class Book implements ItemElement {

  private int price;

  private String isbnNumber;

  public Book(int cost, String isbn) {
    this.price = cost;
    this.isbnNumber = isbn;
  }

  public int getPrice() {
    return price;
  }

  public String getIsbnNumber() {
    return isbnNumber;
  }

  @Override
  public int accept(ShoppingCartVisitor visitor) {
    return visitor.visit(this);
  }

}