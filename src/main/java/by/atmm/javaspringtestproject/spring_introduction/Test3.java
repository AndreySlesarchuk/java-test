package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-03
 */

public class Test3 {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//    Pet pet = context.getBean("myPet", Pet.class);
//    Pet pet = new Cat();
//    Person person = new Person(pet);
    Person person = context.getBean("myPerson", Person.class);
    person.callYourPet();

    System.out.println(person.surname);
    System.out.println(person.age);

    context.close();

  }

}
