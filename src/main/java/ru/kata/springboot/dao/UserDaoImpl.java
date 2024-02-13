package ru.kata.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.kata.springboot.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

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
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User with this id not found");
        }
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        User userid = entityManager.find(User.class, user.getId());
        if (userid == null) {
            throw new EntityNotFoundException("User with this id not found");
        }
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(Integer id) {
        User user = this.getUserById(id);
        if (user == null) {
            throw new EntityNotFoundException("User with this id not found");
        }
        entityManager.remove(user);
    }
}
