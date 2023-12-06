package com.example.s.core.service;

import com.example.s.core.domain.Dashboard;
import com.example.s.core.domain.Team;
import com.example.s.core.domain.repository.DashboardRepository;
import com.example.s.core.domain.repository.TeamRepository;
import com.example.s.exception.ResourceNotFoundException;
import com.example.s.present.request.DashboardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final TeamRepository teamRepository;
    private final DashboardRepository dashboardRepository;

    public Dashboard save(DashboardRequest req) {
        Team team = teamRepository.findById(req.getTeamId()).orElseThrow(ResourceNotFoundException::Default);
        Dashboard dashboard = new Dashboard();
        dashboard.setData(req.getData());
        dashboard.setTeam(team);
        return dashboardRepository.save(dashboard);
    }

    public Dashboard get(String id) {
        return dashboardRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::Default);
    }

}
