package com.example.assignment.service.impl;

import com.example.assignment.dto.TechLeadDto;
import com.example.assignment.service.TechLeadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {
    @Override
    public String save(TechLeadDto dto) {
        return null;
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
