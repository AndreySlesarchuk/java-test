package by.atmm.java.__topics.objects.clone;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectClone {

  // https://www.baeldung.com/java-deep-copy
  public static void main(String[] args) {
    Supplier<String> stringSupplier = () -> "Hello World!";
    Consumer<Object> objectConsumer = System.out::println;

    objectConsumer.accept(stringSupplier.get());

    Sheep original = new Sheep("Dolly");
    Sheep copy = null;
    try {
      copy = (Sheep) original.clone();
    }
    catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    objectConsumer.accept(original != copy); // Will output true, since these are different objects
    objectConsumer.accept(original.getClass() == copy.getClass()); // Will output true, since the type is the same
    objectConsumer.accept(original.equals(copy)); // The result depends on the implementation of the method equals()

    //  Address address = new Address("Downing St 10", "London", "England");
    Address address = new Address().setCountry("England").setCity("London").setStreet("Downing St 10");
    User primeMinister = new User("Prime", "Minister", address);

    User shallowCopy = new User(primeMinister.getFirstName(), primeMinister.getLastName(), primeMinister.getAddress());

    primeMinister.getAddress().setStreet("221b Backer Street");

    objectConsumer.accept(primeMinister != shallowCopy); // Will output true, since these are different objects
    objectConsumer.accept(primeMinister.equals(shallowCopy)); // The result depends on the implementation of the method equals()
    objectConsumer.accept(primeMinister.getAddress()); // Street is 221b Backer Street
    objectConsumer.accept(shallowCopy.getAddress()); // Street is 221b Backer Street

  }
}
