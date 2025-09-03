package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public String getUserName(Model model){
        userService.createTableUsers();
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("countOfUsers",users.size());
        return "users";
    }
}
