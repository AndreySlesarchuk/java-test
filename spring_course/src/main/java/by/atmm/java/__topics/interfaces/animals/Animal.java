package by.atmm.java.__topics.interfaces.animals;

public interface Animal {
  int NUMBER_OF_LEGS = 4;

  void eat();
  void sleep();

  default void makeSound() {
    System.out.println("Animal makes a sound");
  }

  static void info() {
    System.out.println("Animals are living beings.");
  }

}

