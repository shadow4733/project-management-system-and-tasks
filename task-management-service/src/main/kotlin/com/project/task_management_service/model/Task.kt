package com.project.task_management_service.model

import com.project.task_management_service.model.enums.TaskPriority
import com.project.task_management_service.model.enums.TaskStatus
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
data class Task(
    @Id
    val taskId: UUID,
    val taskName: String,
    val taskDescription: String,
    val taskStatus: TaskStatus,
    val taskPriority: TaskPriority,
    val projectId: UUID,
    val projectName: String,
    val userId: UUID,
    val userName: String,
    val profession: String
)
