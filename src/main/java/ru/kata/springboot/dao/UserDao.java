package ru.kata.springboot.dao;


import ru.kata.springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    public void saveUser(User user);

    User getUserById(Integer id);

    public void updateUser(Integer id, User user);

    public void deleteUser(Integer id);
}
