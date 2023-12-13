package com.example.s.core.service;

import com.example.s.core.domain.Permission;
import com.example.s.core.domain.Team;
import com.example.s.core.domain.User;
import com.example.s.core.domain.repository.PermissionRepository;
import com.example.s.core.domain.repository.TeamRepository;
import com.example.s.core.domain.repository.UserRepository;
import com.example.s.exception.ResourceNotFoundException;
import com.example.s.present.request.PermissionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public Permission save(PermissionRequest req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow(ResourceNotFoundException::Default);
        Team team = teamRepository.findById(req.getTeamId()).orElseThrow(ResourceNotFoundException::Default);
        Permission permission = req.ToDomain();
        permission.setUser(user);
        permission.setTeam(team);
        return permissionRepository.save(permission);
    }

    public Permission get(String id) {
        return permissionRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::Default);
    }

    //Todo check permission
    public Permission update(PermissionRequest req, String id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::Default);
        permission.setUpdatedAt(Instant.now());
        permission.setRole(req.getRole());
        return permissionRepository.save(permission);
    }

    //Todo check permission
    public void delete(String id) {
        permissionRepository.deleteById(id);
    }
}
