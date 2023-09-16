package com.example.assignment.service;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.entity.Project;

import java.util.Optional;

public interface ProjectService {
    String saveProject(ProjectDto dto);
    void updateProject(ProjectDto dto);

    void deleteProject(String id);

    ProjectDto view(String id);
}
