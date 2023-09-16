package com.example.assignment.api;

import com.example.assignment.dto.ProjectDto;
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
    String saveProject(@RequestBody ProjectDto project) {
        projectService.save(project);
        return "saved!";
    }

    @DeleteMapping(params = "id")
    private String delete(String id) {
        projectService.delete(id);
        return "deleted!";
    }

    @PutMapping
    private String update(@RequestBody ProjectDto projectDto) {
        projectService.update(projectDto);
        return "updated!";
    }

    @GetMapping(params = "id")
    private String viewProject(String id) {
        ProjectDto dto = projectService.view(id);
        return dto.toString();
    }
}
