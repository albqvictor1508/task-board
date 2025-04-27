package me.dio.task_board.service;

import me.dio.task_board.entity.Board;
import me.dio.task_board.entity.Workspace;
import me.dio.task_board.repository.BoardRepository;
import me.dio.task_board.repository.TaskRepository;
import me.dio.task_board.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private BoardRepository  boardRepo;
    @Autowired
    private WorkspaceRepository workspaceRepo;

    public void addNewTask(Long workspaceId, Long boardId) {
        Board b = boardRepo.findById(boardId).get();

    }
}
