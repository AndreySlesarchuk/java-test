package by.atmm.java.__early.behavioral.visitor.items;

/**
 * Created by Andrey Slesarchuk on 11/29/2020.
 */
public interface ItemElement {
  int accept(ShoppingCartVisitor visitor);
}
