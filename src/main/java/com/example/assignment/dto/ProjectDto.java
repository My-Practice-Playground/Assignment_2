package com.example.assignment.dto;

import com.example.assignment.entity.Techlead;

public record ProjectDto(String id, String description, Double price, TechleadDto techlead) {
}