package by.atmm.java.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-02
 */

public class Test2 {
  public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    Pet pet = context.getBean("myPet", Pet.class);
    pet.say();

    context.close();

  }
}
