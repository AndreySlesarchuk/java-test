package by.atmm.java.early.behavioral.visitor.items;

/**
 * Created by Andrey Slesarchuk on 11/29/2020.
 */
public interface ShoppingCartVisitor {
  int visit(Book book);

  int visit(Fruit fruit);
}
