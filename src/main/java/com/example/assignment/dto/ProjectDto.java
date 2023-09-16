package com.example.assignment.dto;

/**
 * DTO for {@link com.example.assignment.entity.custom.Project}
 */
public record ProjectDto(String id, String description, Double price, TechLeadDto techlead) {
}