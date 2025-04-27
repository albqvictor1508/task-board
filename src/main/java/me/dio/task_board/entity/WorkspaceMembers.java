package me.dio.task_board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkspaceMembers {
    //no futuro essa classe pode ser útil
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    private String role;
    @Column(name = "joined_at")
    private LocalDateTime joinedAt;
}
//