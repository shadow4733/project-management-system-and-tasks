package com.project.project_management_service.model;

import com.project.project_management_service.model.enums.Profession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;
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
    @ManyToOne
    private VerifiedUser creator;
    private String projectName;
    private String projectDescription;
    @ManyToMany
    private Set<VerifiedUser> projectMembers;
    @ElementCollection(targetClass = Profession.class)
    @Enumerated(EnumType.STRING)
    private Set<Profession> requiredProfessions;

    @Override
    public int hashCode() {
        return Objects.hash(projectId, creator, projectName, projectDescription);
    }
}