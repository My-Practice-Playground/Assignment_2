package com.example.assignment.entity.custom;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Techlead {
    @OneToMany(targetEntity = Project.class, mappedBy = "techlead", cascade = CascadeType.REMOVE)
    List<Project> projectList = new ArrayList<>();
    @Id
    private String id;
    private String name;
    private Double salary;

    public Techlead() {
    }

    public Techlead(String id, String name, Double salary, List<Project> projectList) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.projectList = projectList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "Techlead{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }
}
