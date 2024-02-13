package ru.kata.springboot.dao;


import ru.kata.springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);
}
