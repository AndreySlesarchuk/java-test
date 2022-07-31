package by.atmm.java.early.behavioral.visitor.animal;

/**
 * Created by Andrey Slesarchuk on 05/25/2020.
 */
public interface AnimalVisitor {
  void action(Cat cat);

  void action(Dog dog);

  void action(Chicken chicken);
}
