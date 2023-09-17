package com.example.assignment.service.impl;

import com.example.assignment.dto.TechLeadDto;
import com.example.assignment.entity.custom.TechLead;
import com.example.assignment.repo.TechleadRepository;
import com.example.assignment.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void update(TechLeadDto dto) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public TechLeadDto view(String id) {
        return null;
    }
}
