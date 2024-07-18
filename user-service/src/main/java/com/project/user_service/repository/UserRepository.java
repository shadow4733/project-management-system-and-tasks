package com.project.user_service.repository;

import com.project.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User findByEmailToken(String token);
    User findByUsername(String username);
    Optional<User> findByUserId(UUID id);
}
