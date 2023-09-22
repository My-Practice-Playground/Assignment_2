package com.example.assignment.entity.custom;

import com.example.assignment.entity.SuperEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "techlead")
public class TechLead implements SuperEntity {
    @OneToMany(targetEntity = Project.class, mappedBy = "techlead", cascade = CascadeType.REMOVE)
    List<Project> projectList = new ArrayList<>();
    @Id
    private String id;
    private String name;
    private Double salary;

    public TechLead() {
    }

    public TechLead(String id, String name, Double salary, List<Project> projectList) {
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
        return "TechLead{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }
}
