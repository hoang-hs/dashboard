package com.example.s.present.controller;

import com.example.s.core.domain.Dashboard;
import com.example.s.core.domain.Permission;
import com.example.s.core.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/histories")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;


    @GetMapping("/")
    List<Dashboard> get() {
        return historyService.get();
    }

}
