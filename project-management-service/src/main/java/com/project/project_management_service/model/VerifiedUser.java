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
@Table(name = "verified_users")
public class VerifiedUser {
    @Id
    private UUID userId;
    private String username;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    @OneToMany(mappedBy = "creator")
    private Set<Project> managedProjects;
    @ManyToMany(mappedBy = "projectMembers")
    private Set<Project> memberProjects;

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, profession);
    }
}