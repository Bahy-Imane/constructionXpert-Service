package com.project.manager.service;


import com.project.manager.model.Project;
import com.project.manager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow();
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project project) {
        Project project1 = projectRepository.findById(id).orElseThrow();
        project1.setProjectName(project.getProjectName());
        project1.setProjectDescription(project.getProjectDescription());
        project1.setProjectStartDate(project.getProjectStartDate());
        project1.setProjectEndDate(project.getProjectEndDate());
        return projectRepository.save(project1);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
