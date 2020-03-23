package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.User;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    private Map<Long, User> userMap;
    private static Long id = 1L;

    public UserDaoImpl() {
        this.userMap = new HashMap<>();
        prepareUserList();
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }


    @Override
    public void deactivateUsers() {
        for (User user : userMap.values()) {
            user.setActive(false);
        }
    }

    @Override
    public void removeUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() < 1) {
            user.setId(id);
            id++;
        }
        userMap.put(user.getId(), user);
    }

    private void prepareUserList() {
        User user = new User();
        user.setLogin("Użytkownik 1");
        user.setEmail("user1@shop.pl");
        user.setAge(18);
        user.setCountry("Polska");
        user.setActive(true);
        saveUser(user);
        User user2 = new User();
        user2.setLogin("Użytkownik 2");
        user2.setEmail("user2@shop.pl");
        user2.setAge(41);
        user2.setCountry("Afganistan");
        user2.setActive(false);
        saveUser(user2);
    }

}
