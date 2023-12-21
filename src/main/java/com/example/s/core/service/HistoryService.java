package com.example.s.core.service;

import com.example.s.core.domain.Dashboard;
import com.example.s.core.domain.History;
import com.example.s.core.domain.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;

    public Page<Dashboard> get(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "updatedAt"));
        String userId = MDC.get("user_id");
        Page<History> historyPage = historyRepository.findAllByUser_Id(pageable, userId);
        return historyPage.map(History::getDashboard);
    }
}
