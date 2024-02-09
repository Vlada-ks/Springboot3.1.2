package ru.kata.springboot.service;


import ru.kata.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    public void saveUser(User user);

    User getUserById(Integer id);

    public void updateUser(Integer id, User user);

    public void deleteUser(Integer id);
}
