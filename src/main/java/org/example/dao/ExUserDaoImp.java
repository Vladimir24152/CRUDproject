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
                    new User(1L,"name1","lastName1",20,"@mail1"),
                    new User(2L,"name2","lastName2",21,"@mail2"),
                    new User(3L,"name3","lastName3",22,"@mail3"),
                    new User(4L,"name4","lastName4",23,"@mail4")
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
    public void updateUser(long id, User newUser) {
        User res = getUserById(id);
        res.setName(newUser.getName());
        res.setLastName(newUser.getLastName());
        res.setAge(newUser.getAge());
        res.setEmail(newUser.getEmail());
    }

    @Override
    public void deleteUser(long id) {
        User res = getUserById(id);
        users.remove(res);
    }

    @Override
    public User getUserById(long id) {
        for (User user: users){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
