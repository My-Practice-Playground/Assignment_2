package com.example.assignment.service.impl;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.dto.TechLeadDto;
import com.example.assignment.entity.custom.Project;
import com.example.assignment.entity.custom.TechLead;
import com.example.assignment.repo.TechleadRepository;
import com.example.assignment.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {
    @Autowired
    private TechleadRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String save(TechLeadDto dto) {
        TechLead techLead = new TechLead();
        techLead.setId(dto.id());
        techLead.setName(dto.name());
        techLead.setSalary(dto.salary());

        if (repository.existsById(techLead.getId())) throw new RuntimeException("Tech lead already exists!");
        repository.save(techLead);
        return "saved!";
    }

    @Override
    public void update(TechLeadDto dto) {

    }

    @Override
    public void delete(String id) {
        if (!repository.existsById(id)) throw new RuntimeException("tl does not exists!");
        repository.deleteById(id);
    }

    @Override
    public TechLeadDto view(String id) {
        if (!repository.existsById(id)) throw new RuntimeException("Techlead not found !");
        TechLead entity = repository.getTechLeadById(id);
        return new TechLeadDto(entity.getId(), entity.getName(), entity.getSalary(), setProjects(entity));
    }

    private List<ProjectDto> setProjects(TechLead entity) {
        if (entity.getProjectList() == null) return null;
        List<ProjectDto> list = new ArrayList<>();
        entity.getProjectList().stream().map(project -> list.add(new ProjectDto(project.getId(), project.getDescription(), project.getPrice(), null)));
        return list;
    }
}
