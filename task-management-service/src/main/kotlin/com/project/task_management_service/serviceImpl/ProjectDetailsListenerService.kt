package com.project.task_management_service.serviceImpl

import com.event_module.model.TaskDetailsEvent
import com.project.task_management_service.model.Task
import com.project.task_management_service.model.enums.TaskPriority
import com.project.task_management_service.model.enums.TaskStatus
import com.project.task_management_service.repository.TaskRepository
import lombok.RequiredArgsConstructor
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ProjectDetailsListenerService(private val taskRepository: TaskRepository) {
    @KafkaListener(topics = ["task-details-topic"], groupId = "task-management-service")
    fun consumeProjectDetailsEvent(projectDetailsEvent: TaskDetailsEvent?) {
        projectDetailsEvent?.let {
            val taskStatus = TaskStatus.valueOf(it.taskStatus)
            val taskPriority = TaskPriority.valueOf(it.taskPriority)

            val task = Task(
                taskId = it.taskId,
                taskName = it.taskName,
                taskDescription = it.taskDescription,
                taskStatus = taskStatus,
                taskPriority = taskPriority,
                projectId = it.projectId,
                projectName = it.projectName,
                userId = it.userId,
                userName = it.username,
                profession = it.profession
            )

            taskRepository.save(task)
        }
    }
}