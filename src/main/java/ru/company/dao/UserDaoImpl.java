package ru.company.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.company.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository

public class UserDaoImpl implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User user, long id) {
        User user1 = show((int) id);
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        entityManager.merge(user1);
    }

    public User show(int id) {
        return getAllUsers().stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
