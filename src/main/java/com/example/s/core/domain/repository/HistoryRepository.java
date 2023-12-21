package com.example.s.core.domain.repository;

import com.example.s.core.domain.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoryRepository extends MongoRepository<History, String> {
    Page<History> findAllByUser_Id(Pageable pageable, String userId);

    Optional<History> findByUser_IdAndDashboard_Id(String userId, String dashboardId);

}
