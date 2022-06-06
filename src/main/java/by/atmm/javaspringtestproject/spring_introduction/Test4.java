package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-06
 */

public class Test4 {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

    Dog myDog = context.getBean("myPet", Dog.class);
    Dog yourDog = context.getBean("myPet", Dog.class);


    System.out.println("variables refer to the same object? " + (myDog==yourDog));

    System.out.println(myDog);
    System.out.println(yourDog);

    context.close();

  }

}
