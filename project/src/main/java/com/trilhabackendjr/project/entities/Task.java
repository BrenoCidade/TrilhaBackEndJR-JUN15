package com.trilhabackendjr.project.entities;

import com.trilhabackendjr.project.controllers.dto.CreateTaskDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "tb_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    private String nameTask;
    private String description;

    @CreationTimestamp
    private Instant creationTimestamp;

    public Task() {}

    public Task(@Valid CreateTaskDto dto) {
        this.nameTask = dto.getNameTask();
        this.description = dto.getDescription();
    }

    public Task(Long taskId, String nameTask, String description, Instant creationTimestamp) {
        this.taskId = taskId;
        this.nameTask = nameTask;
        this.description = description;
        this.creationTimestamp = creationTimestamp;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
}
