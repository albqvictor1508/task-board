package me.dio.task_board.service;

import me.dio.task_board.entity.User;
import me.dio.task_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public void save(User u) {
        userRepo.save(u);
    }
}
