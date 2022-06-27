package by.atmm.java.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-08
 */

public class ConfigWithAnnotations1 {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

    Person person = context.getBean("personBean", Person.class);
    person.callYourPet();

    System.out.println(person.getSurname());
    System.out.println(person.getAge());


//    Pet pet = context.getBean("catBean", Pet.class);
//    pet.say();


    context.close();
  }
}
