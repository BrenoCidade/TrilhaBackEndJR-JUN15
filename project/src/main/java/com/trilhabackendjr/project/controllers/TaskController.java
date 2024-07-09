package com.trilhabackendjr.project.controllers;

import com.trilhabackendjr.project.controllers.dto.CreateTaskDto;
import com.trilhabackendjr.project.entities.Task;
import com.trilhabackendjr.project.repository.TaskRepository;
import com.trilhabackendjr.project.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Cria uma nova tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody @Valid CreateTaskDto body){
        var newtask = new Task(body);

        this.taskRepository.save(newtask);

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Lista todas as tarefas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de tarefas encontrada"),
    })
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAll(){
        List<Task> tasks = (List<Task>) taskRepository.findAll();
        return ResponseEntity.ok().body(tasks);
    }

    @Operation(summary = "Busca uma tarefa pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable Long taskId){
        return ResponseEntity.ok().body(taskService.findById(taskId));
    }

    @Operation(summary = "Exclui uma tarefa pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tarefa excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @DeleteMapping("/tasks/{taskId}")
    public void deleteById(@PathVariable Long taskId){
        taskService.deleteById(taskId);
    }

    @Operation(summary = "Atualiza uma tarefa pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Task> updateById(@RequestBody Task task, @PathVariable Long taskId) {
        return ResponseEntity.ok().body(taskService.updateById(task,taskId));
    }
}