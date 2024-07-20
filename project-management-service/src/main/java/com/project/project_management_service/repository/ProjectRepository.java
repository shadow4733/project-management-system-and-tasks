package com.project.project_management_service.repository;

import com.project.project_management_service.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID>{
}
