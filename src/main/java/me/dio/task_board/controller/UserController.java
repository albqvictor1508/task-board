package me.dio.task_board.controller;

import me.dio.task_board.entity.User;
import me.dio.task_board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping
    public List<User> findAllUsers() {
        return service.findAll();
    }

    @PutMapping
    public User updateUser(@RequestBody User u) {
        return service.update(u);
    }
}
