package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ExUserDaoImp implements UserDao{

    private List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User("name1","lastName1",20,"@mail1"),
                    new User("name2","lastName2",21,"@mail2"),
                    new User("name3","lastName3",22,"@mail3"),
                    new User("name4","lastName4",23,"@mail4")
            )
    );

    @Override
    public void createTableUsers() {

    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User oldUser, User newUser) {

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
