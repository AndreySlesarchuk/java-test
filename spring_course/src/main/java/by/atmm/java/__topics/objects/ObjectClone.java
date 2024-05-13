package by.atmm.java.__topics.objects;

public class ObjectClone {
  public static void main(String[] args) {
    Sheep original = new Sheep("Dolly");
    Sheep copy = null;
    try {
      copy = (Sheep) original.clone();
    }
    catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    System.out.println(original != copy); // Will output true, since these are different objects
    System.out.println(original.getClass() == copy.getClass()); // Will output true, since the type is the same
    System.out.println(original.equals(copy)); // The result depends on the implementation of the method equals()
    System.out.println(original.getName());
    System.out.println(copy.getName());
  }
}
