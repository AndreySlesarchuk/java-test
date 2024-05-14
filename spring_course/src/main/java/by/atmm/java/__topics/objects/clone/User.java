package by.atmm.java.__topics.objects.clone;

import lombok.Data;

@Data
public class User {

  private String firstName;

  private String lastName;

  private Address address;

  public User(String firstName, String lastName, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }
}
