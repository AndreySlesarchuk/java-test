package by.atmm.java.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-02
 */


@Component("personBean")
public class Person {
//  @Autowired
//  @Qualifier("dog")
  private Pet pet;

  @Value("${person.surname}")
  String surname;
  @Value("${person.age}")
  int age;

    public Person() {
      System.out.println("Person bean is created!");
    }

  @Autowired
  public Person(@Qualifier("catBean") Pet pet) {
    System.out.println("Person bean is created!");
    this.pet = pet;
  }

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

  // pet -> setPet
  //@Autowired
  public void setPet(Pet pet) {
    System.out.println("Class Person: set pet!");
    this.pet = pet;
  }

  public void callYourPet() {
    System.out.println("Hello, my lovely Pet!");
    pet.say();
  }
}
