package ru.kata.springboot.dao;

import org.springframework.stereotype.Repository;
import ru.kata.springboot.model.User;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User getUserById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(Integer id, User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(Integer id) {
        User user = this.getUserById(id);
        entityManager.remove(user);
    }
}
