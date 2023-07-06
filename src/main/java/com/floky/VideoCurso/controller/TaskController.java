package com.floky.VideoCurso.controller;

import com.floky.VideoCurso.persistence.entity.Task;
import com.floky.VideoCurso.persistence.entity.TaskStatus;
import com.floky.VideoCurso.service.TaskService;
import com.floky.VideoCurso.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
       return this.taskService.createTask(taskInDTO);

    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status")TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }

    @GetMapping("/id/{id}")
    public List<Task> findAllTaskById(@PathVariable("id")Long id){
        return this.taskService.findAllTaskById(id);
    }

    @GetMapping("/title/{title}")
    public List<Task> findAllTaskByTitle(@PathVariable("title")String title){
        return this.taskService.findAllTaskByTitle(title);
    }

    @PatchMapping("/mark_finish/{id}")
    public ResponseEntity<Void> markFinish(@PathVariable("id")Long id){
        this.taskService.updateTaskFinish(id);
        return ResponseEntity.noContent().build();
    }

}
