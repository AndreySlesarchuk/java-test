package by.atmm.java.__topics.objects;

public class Address {

  private String street;

  private String city;

  private String country;

  public Address() {

  }

  public Address setStreet(String street) {
    this.street = street;
    return this;
  }


  public Address setCity(String city) {
    this.city = city;
    return this;
  }

  public Address setCountry(String country) {
    this.country = country;
    return this;
  }

  public Address(String street, String city, String country) {
    this.street = street;
    this.city = city;
    this.country = country;
  }

  @Override
  public String toString() {
    return "Address{" + "street='" + street + '\'' + ", city='" + city + '\'' + ", country='" + country + '\'' + '}';
  }
}
