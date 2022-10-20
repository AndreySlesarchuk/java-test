package by.atmm.java.__tests.mockito.argumentcaptor;

public interface DeliveryPlatform {

    void deliver(Email email);

    String getServiceStatus();

    AuthenticationStatus authenticate(Credentials credentials);
}
