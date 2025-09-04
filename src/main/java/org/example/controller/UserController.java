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
            return "redirect:/users";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при добавлении пользователя: " + e.getMessage());
            return "add-user";
        }
    }

    @PostMapping("/delete-user")
    public String deleteUser(@RequestParam Long id) {
        try {
            userService.deleteUser(id);
            return "redirect:/users";
        } catch (Exception e) {
            return "redirect:/users?error=delete_failed";
        }
    }

    @GetMapping("/edit-user")
    public String showEditUserForm(@RequestParam Long id, Model model) {
        try {
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
            return "edit-user";
        } catch (Exception e) {
            return "redirect:/users?error=user_not_found";
        }
    }

    @PostMapping("/update-user")
    public String updateUser(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String lastName,
            @RequestParam Integer age,
            @RequestParam String email,
            Model model
    ) {
        try {
            User user = new User(name, lastName, age, email);
            user.setId(id);
            userService.updateUser(id,user);
            return "redirect:/users";
        } catch (Exception e) {
            model.addAttribute("error", "Error updating user: " + e.getMessage());
            model.addAttribute("user", userService.getUserById(id));
            return "edit-user";
        }
    }
}

