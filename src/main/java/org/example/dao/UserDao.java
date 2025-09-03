package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    void createTableUsers();

    void addUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();
}
