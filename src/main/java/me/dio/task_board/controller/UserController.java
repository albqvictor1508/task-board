package me.dio.task_board.controller;

import me.dio.task_board.entity.User;
import me.dio.task_board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    public ResponseEntity<?> save(User u) {
        if(service.existsById(u.getId())) return ResponseEntity.status(401).body("this user already exists");
        service.save(u);
        Object success = new HashMap<>().put("success", true);
        return ResponseEntity.status(201).body(success);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return service.findAll();
    }



    @PutMapping
    public User updateUser(@RequestBody User u) {
        return service.update(u);
    }

    //delete user

    //find by id
}
