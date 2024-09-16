package com.project.task_management_service.serviceImpl

import com.project.task_management_service.model.enums.TaskStatus
import com.project.task_management_service.service.TaskService
import java.util.*

class TaskServiceImpl : TaskService {
    override fun updateTaskStatus(taskId: UUID, status: TaskStatus): String {
        TODO("Not yet implemented")
    }

    override fun deleteTask(taskId: UUID): String {
        TODO("Not yet implemented")
    }

    override fun getTaskById(taskId: UUID): String {
        TODO("Not yet implemented")
    }

    override fun getTasksByProjectId(projectId: UUID): String {
        TODO("Not yet implemented")
    }

    override fun getTasksByUserId(userId: UUID): String {
        TODO("Not yet implemented")
    }
}