package com.example.assignment.service;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.service.util.ProjectNotFoundException;

public interface ProjectService {
    String save(ProjectDto dto) throws RuntimeException;

    void update(ProjectDto dto) throws ProjectNotFoundException;

    void delete(String id) throws ProjectNotFoundException;

    ProjectDto view(String id) throws ProjectNotFoundException;
}
