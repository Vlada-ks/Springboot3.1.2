package ru.kata.springboot.service;


import ru.kata.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);
}
