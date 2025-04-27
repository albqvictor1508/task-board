package me.dio.task_board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Email
    @Column(unique = true)
    private String email;
    @Column(nullable = false, length = 150)
    private String password;

    @Column(nullable = true)
    private LocalDateTime createdAt;
    @ManyToMany(mappedBy = "members")
    private Set<Workspace> workspaces = new HashSet<>();

    public User(Set<Workspace> workspaces, LocalDateTime createdAt, String password, String email, String name, Long id) {
        this.workspaces = workspaces;
        this.createdAt = createdAt;
        this.password = password;
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(Set<Workspace> workspaces) {
        this.workspaces = workspaces;
    }
}
