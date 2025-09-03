package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    void createTableUsers();

    void addUser();

    void deleteUser();

    List<User> getAllUsers();
}
