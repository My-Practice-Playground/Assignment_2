package com.example.assignment.service;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.dto.TechLeadDto;

public interface TechLeadService {
    String save(TechLeadDto dto);

    void update(TechLeadDto dto);

    void delete(String id);

    TechLeadDto view(String id);
}
