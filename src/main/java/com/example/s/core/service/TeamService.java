package com.example.s.core.service;

import com.example.s.core.domain.Permission;
import com.example.s.core.domain.Team;
import com.example.s.core.domain.User;
import com.example.s.core.domain.repository.PermissionRepository;
import com.example.s.core.domain.repository.TeamRepository;
import com.example.s.core.domain.repository.UserRepository;
import com.example.s.core.enums.Role;
import com.example.s.exception.ResourceNotFoundException;
import com.example.s.present.request.TeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;

    public Team save(TeamRequest req) {
        Team team = req.ToDomain();
        teamRepository.save(team);

        User user = userRepository.findById(req.getUserId()).orElseThrow(ResourceNotFoundException::Default);
        Permission permission = new Permission();
        permission.setUser(user);
        permission.setTeam(team);
        permission.setRole(Role.ADMIN);
        permissionRepository.save(permission);
        return team;
    }

    public Team get(String id) {
        return teamRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::Default);
    }

    //Todo check permission
    public Team update(TeamRequest req, String id) {
        Team existedTeam = teamRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::Default);

        Team team = req.ToDomain();
        team.setCreatedAt(existedTeam.getCreatedAt());
        team.setId(id);
        return teamRepository.save(team);
    }

    //Todo check permission
    public void delete(String id) {
        teamRepository.deleteById(id);
    }
}
