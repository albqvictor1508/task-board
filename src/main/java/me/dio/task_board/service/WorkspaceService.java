package me.dio.task_board.service;

import me.dio.task_board.entity.Workspace;
import me.dio.task_board.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceService {
    @Autowired
    private WorkspaceRepository workspaceRepo;

    public void addNewWorkspace(Workspace ws) {
        workspaceRepo.save(ws);
    }

    public List<Workspace> listWorkspaces() {
        return workspaceRepo.findAll();
    }

    public void deleteWorkspace(Long id) {
        workspaceRepo.deleteById(id);
    }
}
