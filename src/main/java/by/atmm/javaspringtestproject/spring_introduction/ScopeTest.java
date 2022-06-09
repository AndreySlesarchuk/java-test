package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-09
 */

public class ScopeTest {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

    Dog myDog = context.getBean("dog", Dog.class);
    Dog yourDog = context.getBean("dog", Dog.class);


    System.out.println("variables refer to the same object? " + (myDog==yourDog));

    System.out.println(myDog);
    System.out.println(yourDog);


    context.close();
  }
}
