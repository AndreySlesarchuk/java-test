package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.stereotype.Component;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-01
 */

@Component
public class Cat implements Pet {
  public Cat() {
    System.out.println("Cat bean is created!");
  }

  @Override
  public void say() {
    System.out.println("Meow-meow");
  }
}
