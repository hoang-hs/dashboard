package com.example.s.core.service;

import com.example.s.core.domain.*;
import com.example.s.core.domain.repository.*;
import com.example.s.core.enums.Role;
import com.example.s.exception.ResourceNotFoundException;
import com.example.s.present.request.DashboardPrivateRequest;
import com.example.s.present.request.DashboardRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final TeamRepository teamRepository;
    private final DashboardRepository dashboardRepository;
    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;

    public Dashboard save(DashboardRequest req) {
        Team team = teamRepository.findById(req.getTeamId()).orElseThrow(ResourceNotFoundException::Default);
        Dashboard dashboard = req.ToDomain();
        dashboard.setTeam(team);
        return dashboardRepository.save(dashboard);
    }

    public Dashboard get(String id) {
        saveHistory(id);
        return dashboardRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::Default);
    }

    private void saveHistory(String id) {
        String userId = MDC.get("user_id");
        Optional<History> optionalHistory = historyRepository.findByUser_IdAndDashboard_Id(userId, id);
        History history = new History();
        if (optionalHistory.isPresent()) {
            history.setDashboard(optionalHistory.get().getDashboard());
            history.setUser(optionalHistory.get().getUser());
            history.setId(optionalHistory.get().getId());
            history.setCreatedAt(optionalHistory.get().getCreatedAt());
        } else {
            User user = userRepository.findById(userId).orElseThrow(ResourceNotFoundException::Default);
            Dashboard dashboard = dashboardRepository.findById(id).orElseThrow(ResourceNotFoundException::Default);
            history.setUser(user);
            history.setDashboard(dashboard);
        }
        historyRepository.save(history);
    }

    public void delete(String id) {
        dashboardRepository.deleteById(id);
    }

    public Dashboard savePrivate(DashboardPrivateRequest req) {
        String userId = MDC.get("user_id");
        User user = userRepository.findById(userId).orElseThrow(ResourceNotFoundException::Default);
        Optional<Team> optionalTeam = teamRepository.findById(userId);
        Team team;
        if (optionalTeam.isEmpty()) {
            team = new Team(userId, user.getUsername());
            teamRepository.save(team);
            Permission permission = new Permission();
            permission.setUser(user);
            permission.setTeam(team);
            permission.setRole(Role.ADMIN);
            permissionRepository.save(permission);
        } else {
            team = optionalTeam.get();
        }

        Dashboard dashboard = req.ToDomain();
        dashboard.setTeam(team);
        return dashboardRepository.save(dashboard);
    }

}
