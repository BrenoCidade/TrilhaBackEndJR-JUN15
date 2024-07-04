package com.trilhabackendjr.project.controllers;

import com.trilhabackendjr.project.controllers.dto.CreateTaskDto;
import com.trilhabackendjr.project.entities.Task;
import com.trilhabackendjr.project.repository.TaskRepository;
import com.trilhabackendjr.project.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class TaskController {

@Autowired
private TaskRepository taskRepository;

@Autowired
private TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody @Valid CreateTaskDto body){
        var newtask = new Task(body);

        this.taskRepository.save(newtask);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAll(){
        List<Task> tasks = (List<Task>) taskRepository.findAll();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable Long taskId){
        return ResponseEntity.ok().body(taskService.findById(taskId));
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteById(@PathVariable Long taskId){
        taskService.deleteById(taskId);
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Task> updateById(@RequestBody Task task, @PathVariable Long taskId) {
        return ResponseEntity.ok().body(taskService.updateById(task,taskId));
    }
}