package me.dio.task_board.repository;

import me.dio.task_board.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "UPDATE users u " +
            "SET name = :u.name, password = :u.password," +
            "email = :u.email,", nativeQuery = true)
    public User updateUser(User u) {}
}
