package com.example.assignment.service.impl;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.dto.TechLeadDto;
import com.example.assignment.entity.custom.TechLead;
import com.example.assignment.repo.TechleadRepository;
import com.example.assignment.service.TechLeadService;
import com.example.assignment.service.util.TechleadNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {
    @Autowired
    private TechleadRepository repository;

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
    public void update(TechLeadDto dto) throws TechleadNotFoundException {
        if (!repository.existsById(dto.id())) throw new TechleadNotFoundException();
        repository.updateNameSalaryById(dto.name(), dto.salary(), dto.id());
    }

    @Override
    public void delete(String id)  throws TechleadNotFoundException{
        if (!repository.existsById(id)) throw new TechleadNotFoundException();
        repository.deleteById(id);
    }

    @Override
    public TechLeadDto view(String id)  throws TechleadNotFoundException{
        if (!repository.existsById(id)) throw new TechleadNotFoundException();
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
