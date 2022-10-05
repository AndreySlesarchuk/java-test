package by.atmm.__gof.behavioral.visitor.items;

/**
 * Created by Andrey Slesarchuk on 11/29/2020.
 */
public interface ItemElement {
  int accept(ShoppingCartVisitor visitor);
}
