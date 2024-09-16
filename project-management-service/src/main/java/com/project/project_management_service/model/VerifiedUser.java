package com.project.project_management_service.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.project_management_service.model.enums.Profession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    @OneToMany(mappedBy = "user")
    private Set<ProjectMember> projectMembers;

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, profession);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerifiedUser that = (VerifiedUser) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(username, that.username) &&
                profession == that.profession;
    }
}