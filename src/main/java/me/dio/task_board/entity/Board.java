package me.dio.task_board.entity;

import jakarta.persistence.*;

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
}
