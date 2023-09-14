package com.example.assignment.service.util;

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
    public String saveProject(Project project) {
        projectRepository.save(project);
        System.out.println("service impl - done");
        return "done";
    }
}
