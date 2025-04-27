package me.dio.task_board.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String title;
    @Column(length = 100, nullable = true)
    private String description;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
