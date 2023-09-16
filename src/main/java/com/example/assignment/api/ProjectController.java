package com.example.assignment.api;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.entity.Project;
import com.example.assignment.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    String saveProject(@RequestBody ProjectDto project) {
        projectService.saveProject(project);
        return project.toString();
    }

    @DeleteMapping(params = "id")
    private String delete(String id){
        projectService.deleteProject(id);
        return "done";
    }


}
