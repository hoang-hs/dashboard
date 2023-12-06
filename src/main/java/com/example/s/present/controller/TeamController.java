package com.example.s.present.controller;

import com.example.s.core.domain.Team;
import com.example.s.core.service.TeamService;
import com.example.s.present.request.TeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController extends BaseController {
    private final TeamService teamService;

    @PostMapping("")
    Team insertUser(@RequestBody TeamRequest req) {
        return teamService.save(req);
    }

    @GetMapping("/{id}")
    Team get(@PathVariable String id) {
        return teamService.get(id);
    }
}
