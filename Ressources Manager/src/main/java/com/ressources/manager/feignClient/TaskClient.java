package com.ressources.manager.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tasks-manager")
public interface TaskClient {

    @GetMapping("/api/task/{taskId}")
    Task getTaskById(@PathVariable Long taskId);

}
