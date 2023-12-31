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
        try {
            if (project == null) {
                return "Empty project details. Please check again!";
            } else if (!project.id().matches("P\\d{3,}")) {
                return "Invalid Project Id!";
            } else if (!project.description().matches("^[A-Za-z0-9\\s]*$")) {
                return "invalid Project Description!";
            } else if (!String.valueOf(project.price()).matches("^-?\\d+(\\.\\d+)?$")) {
                return "Invalid Project Price!";
            }
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        projectService.save(project);
        return "Project successfully saved!";
    }

    @DeleteMapping(params = "id")
    private String delete(String id) {
        if (id == null) {
            return "Empty project details. Please check again!";
        } else if (id.matches("P0\\d{3,}")) {
            return "Invalid Project Id!";
        }

        try {
            projectService.delete(id);
            return "Successfully deleted!";
        } catch (ProjectNotFoundException e) {
            return "Project not exists!";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
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
    private String view(String id) {
        if (id == null) {
            return "Empty project details! ";
        } else if (!id.matches("P0\\d{3,}")) {
            return "Invalid Project Id!";
        }

        try {
            ProjectDto dto = projectService.view(id);
            return dto.toString();
        } catch (ProjectNotFoundException e) {
            return "Project not Found! ";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
