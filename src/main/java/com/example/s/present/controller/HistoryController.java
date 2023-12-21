package com.example.s.present.controller;

import com.example.s.core.domain.Dashboard;
import com.example.s.core.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/histories")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;


    @GetMapping("")
    Page<Dashboard> get(@RequestParam("page") Integer page,
                        @RequestParam("size") Integer size) {
        if (size == 0) {
            size = 10;
        }
        if (page == 0) {
            page = 1;
        }
        return historyService.get(page, size);
    }

}
