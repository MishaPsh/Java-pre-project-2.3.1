package ru.company.dao;

import ru.company.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user,long id);
    User show(int id);
}
