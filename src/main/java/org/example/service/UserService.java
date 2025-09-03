package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {

    void createTableUsers();

    void addUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();
}
