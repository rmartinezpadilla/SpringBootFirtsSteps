package com.floky.VideoCurso.service;

import com.floky.VideoCurso.exceptions.Exceptions;
import com.floky.VideoCurso.mapper.TaskInDTOToTask;
import com.floky.VideoCurso.persistence.entity.Task;
import com.floky.VideoCurso.persistence.entity.TaskStatus;
import com.floky.VideoCurso.persistence.repository.TaskRepository;
import com.floky.VideoCurso.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    //generamos el constructor
    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //vamosa crear una nueva tarea

    public Task createTask(TaskInDTO taskInDTO){
        //convertimor el objeto TasjIndto a task para poder enviarlo al repositorio
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }

    public List<Task> findAllTaskById(Long id){
        return this.repository.findAllTaskById(id);
    }

    public List<Task> findAllTaskByTitle(String title){
        return  this.repository.findAllTaskByTitle(title);
    }
    @Transactional
    public void updateTaskFinish(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new Exceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskFinish(id);
    }


    public void deleteTaskById(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new Exceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

}
