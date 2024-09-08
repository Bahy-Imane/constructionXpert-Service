package com.ressources.manager.feignClient;

import lombok.Data;

@Data
public class Task {

    private Long taskId;
    private String title;
    private String description;
    private String status;
    private Long projectId;

}
