package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-01
 */

@Component
@Scope("prototype")
public class Dog implements Pet {

//  private String name;

  public Dog() {
    System.out.println("Dog bean is created!");
  }

  @Override
  public void say() {
    System.out.println("Boow-wow");
  }

  protected void init() {
    System.out.println("Class Dog: init method");
  }

  private void destroy() {
    System.out.println("Class Dog: destroy method");
  }

  //  public String getName() {
  //    return name;
  //  }
  //
  //  public void setName(String name) {
  //    this.name = name;
  //  }


}
