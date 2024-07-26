package com.project.project_management_service.repository;

import com.project.project_management_service.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {
    boolean existsByProjectName(String projectName);
    Project findByProjectName(String projectName);
}