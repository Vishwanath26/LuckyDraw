package com.grofers.luckydrawservice.controllers;

import com.grofers.luckydrawservice.models.User;
import com.grofers.luckydrawservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@org.springframework.web.bind.annotation.RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return "User saved succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Can't save user";
        }
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUser")
    public Optional<User> getUserById(@RequestParam String userId) {
            return userService.getUser(Long.parseLong(userId));
    }
}
