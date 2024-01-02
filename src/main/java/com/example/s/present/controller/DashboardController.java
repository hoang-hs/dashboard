package com.example.s.present.controller;

import com.example.s.core.domain.Dashboard;
import com.example.s.core.service.DashboardService;
import com.example.s.present.request.DashboardPrivateRequest;
import com.example.s.present.request.DashboardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController extends BaseController {
    private final DashboardService dashboardService;

    @PostMapping("")
    Dashboard save(@RequestBody DashboardRequest req) {
        return dashboardService.save(req);
    }

    @GetMapping("/{id}")
    Dashboard get(@PathVariable String id) {
        return dashboardService.get(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        dashboardService.delete(id);
    }

    @PostMapping("/private")
    Dashboard save(@RequestBody DashboardPrivateRequest req) {
        return dashboardService.savePrivate(req);
    }
}
