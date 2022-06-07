package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-07
 */

public class Test5 {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

    Pet myPet = context.getBean("cat", Pet.class);
    myPet.say();

    context.close();

  }

}
