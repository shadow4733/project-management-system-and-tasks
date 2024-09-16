package com.project.task_management_service.repository

import com.project.task_management_service.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TaskRepository: JpaRepository<Task, UUID> {
}