package by.atmm.java.__early.other.ets;

import java.util.Objects;

public class Test1 {
  int varA;
  int varB;

  Test1(int varA, int varB) {
    this.varA = varA;
    this.varB = varB;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Test1 test1 = (Test1) o;
    return varA == test1.varA && varB == test1.varB;
  }

  @Override public int hashCode() {
    return Objects.hash(varA, varB);
  }

  public static class Main {
    public static void main(String[] args) {
      Object object = new Object();
      int hCode;
      hCode = object.hashCode();
      System.out.println(hCode);
      Test1 object1 = new Test1(5,10);
      hCode = object1.hashCode();
      System.out.println(hCode);
      Test1 object2 = new Test1(5,10);
      hCode = object2.hashCode();
      System.out.println(hCode);
      System.out.println(object1.equals(object2));

    }
  }
}
