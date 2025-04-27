package me.dio.task_board.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String title;
    //posso fazer tags
    @Column(nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;
    //lista de tasks
//    @ManyToOne
//    private Set<Task> tasks = new HashSet<>();
    public Board(Long id, String title, String description, Workspace workspace) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.workspace = workspace;
    }

    public Board() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }
}
