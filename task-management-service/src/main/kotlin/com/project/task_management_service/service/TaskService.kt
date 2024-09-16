package com.project.task_management_service.service

import com.project.task_management_service.model.enums.TaskStatus
import java.util.*

interface TaskService {
    fun updateTaskStatus(taskId: UUID, status: TaskStatus): String
    fun deleteTask(taskId: UUID): String
    fun getTaskById(taskId: UUID): String
    fun getTasksByProjectId(projectId: UUID): String
    fun getTasksByUserId(userId: UUID): String
}