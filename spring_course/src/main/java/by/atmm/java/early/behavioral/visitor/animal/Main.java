package by.atmm.java.early.behavioral.visitor.animal;

/**
 * Created by Andrey Slesarchuk on 05/25/2020.
 */
public class Main {
  public static void main(String[] args) {
    Animal animal = new Chicken();
    animal.accept(new EatVisitor());
    animal.accept(new SoundVisitor());
  }
}
