package me.dio.task_board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false, unique = true)
    private String title;
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    private User createdBy;
    @ManyToMany
    @JoinTable(
            name = "workspace_members",
            joinColumns = @JoinColumn(name = "workspace_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members = new HashSet<>();

    //no excalidraw do notebook tem mais informações (ou no chat do claude)
}
