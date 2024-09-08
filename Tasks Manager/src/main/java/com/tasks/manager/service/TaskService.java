package com.tasks.manager.service;

import com.tasks.manager.feignClient.ProjectClient;
import com.tasks.manager.model.Task;
import com.tasks.manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectClient projectClient;


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }



    public List<Task> getTaskByProjectId(Long id) {
        return taskRepository.getTaskByProjectId(id);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }


    public Task createTask(Task task) {
        if (projectClient.getProjectById(task.getProjectId()) != null) {
            return taskRepository.save(task);
        }
        throw new RuntimeException("Project not found");
    }

    public Task updateTask(Long id, Task task) {
        Task taskToUpdate = taskRepository.findById(id).get();
        taskToUpdate.setTaskTitle(task.getTaskTitle());
        taskToUpdate.setTaskDescription(task.getTaskDescription());
        taskToUpdate.setTaskStatus(task.getTaskStatus());
        return taskRepository.save(taskToUpdate);
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
