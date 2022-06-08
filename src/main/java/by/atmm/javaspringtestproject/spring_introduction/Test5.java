package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-07
 */

public class Test5 {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

    Pet myPet = context.getBean("myPet", Pet.class);
    myPet.say();

    context.close();

  }

}
