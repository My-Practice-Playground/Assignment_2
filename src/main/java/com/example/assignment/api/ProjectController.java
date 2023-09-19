package com.example.assignment.api;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.service.ProjectService;
import com.example.assignment.service.util.ProjectNotFoundException;
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
        if (project == null) {
            return "Empty project details. Please check again!";
        } else if (!project.id().matches("P0\\d{3,}")) {
            return "Invalid Project Id!";
        } else if (!project.description().matches("^[A-Za-z0-9\\s]*$")) {
            return "invalid Project Description!";
        } else if (!String.valueOf(project.price()).matches("^-?\\d+(\\.\\d+)?$")) {
            return "Invalid Project Price!";
        }
        projectService.save(project);
        return "saved!";
    }

    @DeleteMapping(params = "id")
    private String delete(String id) {
        if (id == null) {
            return "Empty project details. Please check again!";
        } else if (id.matches("P0\\d{3,}")) {
            return "Invalid Project Id!";
        }
        projectService.delete(id);
        return "deleted!";
    }

    @PutMapping
    private String update(@RequestBody ProjectDto project) {
        if (project == null) {
            return "Empty project details. Please check again!";
        } else if (!project.id().matches("P0\\d{3,}")) {
            return "Invalid Project Id!";
        } else if (!project.description().matches("^[A-Za-z0-9\\s]*$")) {
            return "invalid Project Description!";
        } else if (!String.valueOf(project.price()).matches("^-?\\d+(\\.\\d+)?$")) {
            return "Invalid Project Price!";
        }

        try {
            projectService.update(project);
            return "Project updated successfully!";
        } catch (ProjectNotFoundException e) {
            return "Project not found !";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping(params = "id")
    private String viewProject(String id) {
        if (id == null) {
            return "Empty project details. Please check again!";
        } else if (!id.matches("P0\\d{3,}")) {
            return "Invalid Project Id!";
        }
        ProjectDto dto = projectService.view(id);
        return dto.toString();
    }
}
