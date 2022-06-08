package by.atmm.javaspringtestproject.spring_introduction;

import org.springframework.stereotype.Component;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-01
 */


public class Dog implements Pet {

//  private String name;
//
//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }


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

}
