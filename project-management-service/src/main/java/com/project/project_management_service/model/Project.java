package com.project.project_management_service.model;

import com.project.project_management_service.model.enums.Profession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID projectId;
    private UUID creatorProjectId;
    private String projectName;
    private String projectDescription;
    private String projectManagers;
    private String projectMembers;
    @ElementCollection(targetClass = Profession.class)
    @Enumerated(EnumType.STRING)
    private Set<Profession> requiredProfessions;
}
