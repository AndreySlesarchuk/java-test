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


//    Address address = new Address("Downing St 10", "London", "England");
    Address address = new Address().setCountry("England").setCity("London").setStreet("Downing St 10");
    User primeMinister = new User("Prime", "Minister", address);

    User shallowCopy = new User(
        primeMinister.getFirstName(), primeMinister.getLastName(), primeMinister.getAddress());

    primeMinister.getAddress().setStreet("221b Backer Street");

    System.out.println(primeMinister != shallowCopy); // Will output true, since these are different objects
    System.out.println(primeMinister.equals(shallowCopy)); // The result depends on the implementation of the method equals()
    System.out.println(primeMinister.getAddress()); // Street is 221b Backer Street
    System.out.println(shallowCopy.getAddress()); // Street is 221b Backer Street

  }
}
