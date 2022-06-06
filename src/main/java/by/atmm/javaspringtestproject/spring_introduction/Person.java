package by.atmm.javaspringtestproject.spring_introduction;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-02
 */


public class Person {

  String surname;

  int age;

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    System.out.println("Class Person: set surname!");
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    System.out.println("Class Person: set age!");
    this.age = age;
  }

  private Pet pet;

  public Person() {
    System.out.println("Person bean is created!");
  }

  public Person(Pet pet) {
    System.out.println("Person bean is created!");
    this.pet = pet;
  }

  // pet -> setPet
  public void setPet(Pet pet) {
    System.out.println("Class Person: set pet!");
    this.pet = pet;
  }

  public void callYourPet() {
    System.out.println("Hello, my lovely Pet!");
    pet.say();
  }
}
