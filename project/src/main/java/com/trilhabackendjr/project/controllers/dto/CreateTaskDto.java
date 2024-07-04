package com.trilhabackendjr.project.controllers.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateTaskDto {

    @NotBlank
    private String nameTask;

    @NotBlank
    private String description;

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
}
