package com.example.assignment.service;

import com.example.assignment.dto.ProjectDto;

public interface ProjectService {
    String save(ProjectDto dto);

    void update(ProjectDto dto);

    void delete(String id);

    ProjectDto view(String id);
}
