package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUserName(Model model){
        userService.createTableUsers();
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("countOfUsers",users.size());
        return "users";
    }

    @GetMapping("/add-user")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add-user")
    public String addUser(
            @RequestParam(value = "name") String name
            ,@RequestParam(value = "lastName") String lastName
            ,@RequestParam(value = "age") Integer age
            ,@RequestParam(value = "email") String email
            ,Model model
    ) {
        try {
            userService.addUser(new User(name,lastName,age,email));
            return "redirect:/users"; // Перенаправляем на список пользователей
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при добавлении пользователя: " + e.getMessage());
            return "add-user";
        }
    }
}
