package by.atmm.gof.behavioral.visitor.animal;

/**
 * Created by Andrey Slesarchuk on 05/25/2020.
 */
public class Dog implements Animal {
  @Override
  public void accept(AnimalVisitor animalVisitor) {
    animalVisitor.action(this);
  }
}
