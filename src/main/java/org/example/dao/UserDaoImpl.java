package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    @Override
    public void createTableUsers() {

    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(long id, User newUser) {

    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }
}
