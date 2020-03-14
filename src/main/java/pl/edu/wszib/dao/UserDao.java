package pl.edu.wszib.dao;

import pl.edu.wszib.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> getUsers();

    void deactivateUsers();

    void saveUser(User user);

    void removeUser(Long id);

    User getById(Long id);


}
