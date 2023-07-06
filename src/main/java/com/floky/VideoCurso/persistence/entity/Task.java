package com.floky.VideoCurso.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name =  "test")
public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String title;
        private String description;
        //fecha finalizacion estimada
        private LocalDateTime createDate;
        private LocalDateTime eta;
        private Boolean finished;
        private TaskStatus taskStatus;

}
