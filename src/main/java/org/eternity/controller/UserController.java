package org.eternity.controller;

import org.eternity.models.User;
import org.eternity.repositories.UserRepository;
import org.eternity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
//        System.out.println(user.getUsername());
//        System.out.println(user.getPhone());
        return userService.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

}
