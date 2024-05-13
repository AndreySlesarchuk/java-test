package by.atmm.java.__topics.objects;

public class ObjectClone {

  // https://www.baeldung.com/java-deep-copy
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


    Address address = new Address("Downing St 10", "London", "England");
    User primeMinister = new User("Prime", "Minister", address);

    User shallowCopy = new User(
        primeMinister.getFirstName(), primeMinister.getLastName(), primeMinister.getAddress());

    primeMinister.getAddress().setStreet("Downing St 13");

    System.out.println(primeMinister != shallowCopy); // Will output true, since these are different objects
    System.out.println(primeMinister.getClass() == shallowCopy.getClass()); // Will output true, since the type is the same
    System.out.println(primeMinister.equals(shallowCopy)); // The result depends on the implementation of the method equals()
    System.out.println(primeMinister.getAddress()); // "Downing St 13"
    System.out.println(shallowCopy.getAddress()); // "Downing St 13"

  }
}
