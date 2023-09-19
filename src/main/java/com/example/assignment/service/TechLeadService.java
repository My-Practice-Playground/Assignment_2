package com.example.assignment.service;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.dto.TechLeadDto;
import com.example.assignment.service.util.TechleadNotFoundException;

public interface TechLeadService {
    String save(TechLeadDto dto) throws RuntimeException;

    void update(TechLeadDto dto) throws TechleadNotFoundException;

    void delete(String id) throws TechleadNotFoundException;

    TechLeadDto view(String id) throws TechleadNotFoundException;
}
