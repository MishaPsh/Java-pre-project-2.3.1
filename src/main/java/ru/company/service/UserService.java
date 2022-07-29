package ru.company.service;

import ru.company.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers ();
    Object getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user,long id);
    User show(int id);
}
