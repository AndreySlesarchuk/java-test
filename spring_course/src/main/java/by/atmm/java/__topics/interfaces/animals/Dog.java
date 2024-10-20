package by.atmm.java.__topics.interfaces.animals;

public class Dog implements Animal, Pet {



  @Override
  public void eat() {
    System.out.println("Dog eats.");
  }

  @Override
  public void sleep() {
    System.out.println("Dog sleeps.");
  }

  @Override
  public void play() {
    System.out.println("Dog plays.");
  }
}
