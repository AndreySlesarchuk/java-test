package by.atmm.java.__topics.objects;

import lombok.Data;

@Data
public class Address {

  private String street;

  private String city;

  private String country;

  public Address(String street, String city, String country) {
    this.street = street;
    this.city = city;
    this.country = country;
  }
}
