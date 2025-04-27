package me.dio.task_board.service;

import me.dio.task_board.entity.User;
import me.dio.task_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public void save(User u) {
        userRepo.save(u);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
        return userRepo.findById(id).get();
    }

    public User update(User newUserData) {
        User u = userRepo.findById(newUserData.getId()).get();
        u.setName(newUserData.getName());
        u.setEmail(newUserData.getEmail());
        u.setPassword(newUserData.getPassword());
        userRepo.save(u);
        return u;
    }
}
