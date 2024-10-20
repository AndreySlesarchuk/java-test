package by.atmm.java.__topics.interfaces.animals;

public class Test {
  public static void main(String[] args) {
    Dog dog = new Dog();
    Animal animal = dog;

    dog.makeSound();
    dog.eat();
    dog.play();
    dog.sleep();
    int numberOfLegs = Animal.NUMBER_OF_LEGS;
    System.out.println("Number of legs: " + numberOfLegs);
    Animal.info();
    animal.eat();
    //animal.play();
  }
}
