package com.example.assignment.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class Project implements SuperEntity {
    @Id
    String id;
    @Column(nullable = false, columnDefinition = "Text")
    String description;
    @Column(nullable = false)
    Double price;

}
