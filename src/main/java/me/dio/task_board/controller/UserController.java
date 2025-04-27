package me.dio.task_board.controller;

import me.dio.task_board.dto.UserDTO;
import me.dio.task_board.entity.User;
import me.dio.task_board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User u) {
        service.save(u);
        Object success = new HashMap<>().put("success", true);
        return ResponseEntity.status(201).body(success);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return service.findAll();
    }

    @PutMapping
    public User updateUser(@RequestBody UserDTO u) {
        return service.update(u);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
