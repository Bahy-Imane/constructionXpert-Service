package com.tasks.manager.feignClient;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Project {

    private Long projectId;
    private String projectName;
    private String projectDescription;
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;
}
