package com.example.assignment.dto;

import java.util.List;

public record TechLeadDto(String id, String name, Double salary, List<ProjectDto> projects) {
}
