package com.example.assignment.dto;

import java.util.List;

/**
 * DTO for {@link com.example.assignment.entity.custom.TechLead}
 */
public record TechLeadDto(String id, String name, Double salary, List<ProjectDto> projects) {
}
