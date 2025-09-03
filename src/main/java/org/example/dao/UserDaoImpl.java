package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void createTableUsers() {

    }

    @Override
    public void addUser() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }
}
