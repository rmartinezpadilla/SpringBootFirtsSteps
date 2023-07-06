package com.floky.VideoCurso.service.dto;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskInDTO {
    private String title;
    private String description;
    //fecha finalizacion estimada
    private LocalDateTime eta;
}
