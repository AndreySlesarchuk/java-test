package by.atmm.java.__early.__topics.interfaces;

public class C implements A, B {

  public void fooA() {
    A.super.foo();
  }

  public void fooB() {
    B.super.foo();
  }

  @Override public void foo() {
    A.super.foo();
  }

}
