package com.example.s.present.controller;

import com.example.s.core.domain.Team;
import com.example.s.core.service.TeamService;
import com.example.s.present.request.TeamRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @PutMapping("/{id}")
    Team update(@RequestBody @Valid TeamRequest req, @PathVariable @NotBlank String id) {
        return teamService.update(req, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable @NotBlank String id) {
        teamService.delete(id);
    }

    @GetMapping("/a")
    Page<Team> getByUser(@RequestParam("page") Integer page,
                         @RequestParam("size") Integer size) {
        if (size == 0) {
            size = 10;
        }
        if (page == 0) {
            page = 1;
        }
        return teamService.getByUser(page, size);
    }
}