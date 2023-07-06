package com.floky.VideoCurso.persistence.repository;

import com.floky.VideoCurso.persistence.entity.Task;
import com.floky.VideoCurso.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //Query spring data JPA
    public List<Task> findAllByTaskStatus(TaskStatus status);
    public List<Task> findAllTaskById(Long id);
    public List<Task> findAllTaskByTitle(String title);

    //consulta nativa

    @Modifying
    @Query(value = "UPDATE test SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    public void markTaskFinish(@Param("id")Long id);


}
