package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-06
 */

public class Test5 {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

    Dog myDog = context.getBean("myPet", Dog.class);
    myDog.say();

    Dog yourDog = context.getBean("myPet", Dog.class);
    yourDog.say();

    context.close();

  }

}
