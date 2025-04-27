package me.dio.task_board.service;

import me.dio.task_board.entity.User;
import me.dio.task_board.entity.Workspace;
import me.dio.task_board.repository.UserRepository;
import me.dio.task_board.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WorkspaceService {
    @Autowired
    private WorkspaceRepository workspaceRepo;
    @Autowired
    private UserRepository userRepo;

    public void addNewWorkspace(Workspace ws) {
        workspaceRepo.save(ws);
    }

    public List<Workspace> listWorkspaces() {
        return workspaceRepo.findAll();
    }

    public void deleteWorkspace(Long id) {
        workspaceRepo.deleteById(id);
    }

    public Workspace findById(Long id) {
        return workspaceRepo.findById(id).get();
    }

    public void addNewMember(Long workspaceId, Long userId) {
        Workspace ws = workspaceRepo.findById(workspaceId).get();
        User u = userRepo.findById(userId).get();

        if(ws.getMembers().contains(u)) throw new RuntimeException("user is already in workspace");
        ws.getMembers().add(u);
        workspaceRepo.save(ws);
    }

    public void deleteMember(Long workspaceId, Long userId) {
        Workspace ws = workspaceRepo.findById(workspaceId).get();
        User u = userRepo.findById(userId).get();

        if(!ws.getMembers().contains(u)) throw new RuntimeException("user not exists in workspace");
        ws.getMembers().remove(u);
    }

    public Set<User> getWorkspaceMembers(Long workspaceId) {
        Workspace workspace = workspaceRepo.findById(workspaceId).get();
        return workspace.getMembers();
    }
}
