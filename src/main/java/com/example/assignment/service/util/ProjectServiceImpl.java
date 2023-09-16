package com.example.assignment.service.util;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.entity.Project;
import com.example.assignment.repo.ProjectRepository;
import com.example.assignment.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public String saveProject(ProjectDto dto) {
        System.out.print("service impl: " + dto);

        Project entity = new Project();
        entity.setId(dto.id());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        projectRepository.save(entity);
        return "done";
    }

    @Override
    public void updateProject(ProjectDto dto, String id) {

    }
}
