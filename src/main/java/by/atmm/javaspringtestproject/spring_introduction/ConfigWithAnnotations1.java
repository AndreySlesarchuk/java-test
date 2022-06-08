package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
