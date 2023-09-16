package com.example.assignment.service;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.entity.Project;

public interface ProjectService {
    String saveProject(ProjectDto dto);
    void updateProject(ProjectDto dto,String id);


}
