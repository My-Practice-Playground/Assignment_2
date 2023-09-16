package com.example.assignment.service.impl;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.dto.TechLeadDto;
import com.example.assignment.entity.custom.Project;
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
    public String save(ProjectDto dto) {
        System.out.print("service impl: " + dto);
        Project entity = new Project();
        entity.setId(dto.id());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());

        projectRepository.save(entity);
        return "done";
    }

    @Override
    public void update(ProjectDto dto) {
        if (!projectRepository.existsById(dto.id())) throw new RuntimeException("Project not found !");
        projectRepository.updateDescriptionAndPriceById(dto.description(), dto.price(), dto.id());
    }

    @Override
    public void delete(String id) {
        if (!projectRepository.existsById(id)) throw new RuntimeException("Project not found !");
        Project project = new Project();
        project.setId(id);
        projectRepository.delete(project);
    }

    @Override
    public ProjectDto view(String id) {
        if (!projectRepository.existsById(id)) throw new RuntimeException("Project not found !");
        Project project = projectRepository.getProjectById(id);
        return new ProjectDto(project.getId(), project.getDescription(), project.getPrice(), getTechlead(project));
    }

    private TechLeadDto getTechlead(Project project) {
        return (project.getTechlead() == null)
                ? null
                : new TechLeadDto(
                        project.getTechlead().getId(),
                project.getTechlead().getName(),
                project.getTechlead().getSalary(),
                null
        );
    }
}
