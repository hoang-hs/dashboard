package com.example.s.core.service;

import com.example.s.core.domain.Dashboard;
import com.example.s.core.domain.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;

    public List<Dashboard> get(String id) {
        Pageable pageable = PageRequest.of(1, 1);
        Sort sort = Sort.by(Sort.Direction.ASC, "updatedAt");
//        List<History> histories = historyRepository.findAllByUser_Id(pageable, sort, id);
//        return histories.stream().map(History::getDashboard).collect(Collectors.toList());
        return new ArrayList<>();
    }
}
