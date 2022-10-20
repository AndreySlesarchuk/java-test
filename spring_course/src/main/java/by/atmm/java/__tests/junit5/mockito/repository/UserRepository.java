package by.atmm.java.__tests.junit5.mockito.repository;

import by.atmm.java.__tests.junit5.mockito.User;

public interface UserRepository {

    User insert(User user);
    boolean isUsernameAlreadyExists(String userName);
    
}
