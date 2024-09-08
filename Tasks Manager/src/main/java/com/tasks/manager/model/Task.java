package com.tasks.manager.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskStatus;
    private Long projectId;

}
