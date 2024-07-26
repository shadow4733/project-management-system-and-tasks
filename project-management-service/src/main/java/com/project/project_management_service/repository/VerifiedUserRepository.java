package com.project.project_management_service.repository;

import com.project.project_management_service.model.VerifiedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VerifiedUserRepository extends JpaRepository<VerifiedUser, UUID> {
    Optional<VerifiedUser> findByUsername(String username);
}