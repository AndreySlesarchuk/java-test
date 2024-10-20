package by.atmm.java.__topics.interfaces.abc;

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
