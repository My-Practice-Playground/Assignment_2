package com.example.assignment.dto;

import java.util.List;

public record TechleadDto(String id, String name, Double salary, List<ProjectDto> projects) {
}
