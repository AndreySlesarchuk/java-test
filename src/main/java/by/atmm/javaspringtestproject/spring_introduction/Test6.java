package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-09
 */

public class Test6 {

  public static void main(String[] args) {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

    Pet cat = context.getBean("catBean", Pet.class);
    cat.say();

    Person person = context.getBean("personBean", Person.class);
    person.callYourPet();

    context.close();

  }

}
