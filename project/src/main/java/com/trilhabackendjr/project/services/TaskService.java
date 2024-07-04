package com.trilhabackendjr.project.services;

import com.trilhabackendjr.project.entities.Task;
import com.trilhabackendjr.project.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Optional<Task> findById(Long taskId){
        return taskRepository.findById(taskId);
    }

    public Task insert(Task task){
        return taskRepository.save(task);
    }

    public Task updateById(Task task, Long taskId){
        Task newTask = taskRepository.getReferenceById(taskId);
        updateTask(newTask, task);
        return taskRepository.save(newTask);
    }

    private void updateTask(Task newTask, Task task) {
        newTask.setNameTask(task.getNameTask());
        newTask.setDescription(task.getDescription());
    }

    public void deleteById(Long taskId){
        taskRepository.deleteById(taskId);
    }
}
