package com.event_module.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDetailsEvent implements Serializable {
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
