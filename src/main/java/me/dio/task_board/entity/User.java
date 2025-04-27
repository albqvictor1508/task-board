package me.dio.task_board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private LocalDateTime createdAt; //setar pra auto quando for criado
    @ManyToMany(mappedBy = "members")
    private Set<Workspace> workspaces;
}
