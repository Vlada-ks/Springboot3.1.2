package ru.kata.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.springboot.dao.UserDao;
import ru.kata.springboot.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }


    @Override
    public void updateUser(Integer id, User user) {
        userDao.updateUser(id, user);
    }


    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
