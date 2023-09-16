package com.example.assignment.service.util;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.entity.Project;
import com.example.assignment.repo.ProjectRepository;
import com.example.assignment.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public String saveProject(ProjectDto dto) {

        System.out.println("service impl - done");
        return "done";
    }

    @Override
    public void updateProject(ProjectDto dto, String id) {

    }
}
