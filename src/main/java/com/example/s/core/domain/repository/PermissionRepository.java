package com.example.s.core.domain.repository;

import com.example.s.core.domain.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends MongoRepository<Permission, String> {
    Page<Permission> findAllByUser_Id(Pageable pageable, String userId);
}
