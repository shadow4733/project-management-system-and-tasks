package com.project.project_management_service.repository;

import com.project.project_management_service.model.VerifiedUser;
import com.project.project_management_service.model.enums.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VerifiedUserRepository extends JpaRepository<VerifiedUser, UUID> {
    Optional<VerifiedUser> findByUsername(String username);
    List<VerifiedUser> findAllByProfession(Profession profession);
}