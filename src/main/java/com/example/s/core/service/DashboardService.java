package com.example.s.core.service;

import com.example.s.core.domain.Dashboard;
import com.example.s.core.domain.History;
import com.example.s.core.domain.Team;
import com.example.s.core.domain.User;
import com.example.s.core.domain.repository.DashboardRepository;
import com.example.s.core.domain.repository.HistoryRepository;
import com.example.s.core.domain.repository.TeamRepository;
import com.example.s.core.domain.repository.UserRepository;
import com.example.s.exception.ResourceNotFoundException;
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

    public Dashboard save(DashboardRequest req) {
        Team team = teamRepository.findById(req.getTeamId()).orElseThrow(ResourceNotFoundException::Default);
        Dashboard dashboard = req.ToDomain();
        dashboard.setTeam(team);
        return dashboardRepository.save(dashboard);
    }

    //Todo upsert
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
            User user = userRepository.findById("").orElseThrow(ResourceNotFoundException::Default);
            Dashboard dashboard = dashboardRepository.findById(id).orElseThrow(ResourceNotFoundException::Default);
            history.setUser(user);
            history.setDashboard(dashboard);
        }
        historyRepository.save(history);
    }
}
