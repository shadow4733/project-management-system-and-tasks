package com.project.project_management_service.model;

import com.project.project_management_service.model.enums.Profession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID taskId;
    private String taskName;
    private String taskDescription;
    private String taskStatus;
    private String taskPriority;
    private UUID projectId;
    private String projectName;
    private UUID userId;
    private String username;
    private String profession;
}