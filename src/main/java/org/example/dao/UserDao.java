package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    void createTableUsers();

    void addUser(User user);

    void updateUser(User oldUser, User newUser);

    void deleteUser(User user);

    List<User> getAllUsers();
}
