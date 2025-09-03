package org.example.dao;

import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ExUserDaoImp implements UserDao{

    private List<User> users;

    @Override
    public void createTableUsers() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
