package com.example.assignment.api;

import com.example.assignment.entity.Project;
import com.example.assignment.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    String saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @DeleteMapping
    void saveProject() {
        System.out.println("Delete");
    }
}
