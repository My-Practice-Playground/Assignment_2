package com.example.assignment.entity.custom;


import com.example.assignment.entity.SuperEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project implements SuperEntity {
    @Id
    String id;
    @Column(nullable = false, columnDefinition = "Text")
    String description;
    @Column(nullable = false)
    Double price;
    @ManyToOne
    TechLead techlead;

    public Project() {
    }

    public Project(String id, String description, Double price, TechLead techlead) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.techlead = techlead;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TechLead getTechlead() {
        return techlead;
    }

    public void setTechlead(TechLead techlead) {
        this.techlead = techlead;
    }

    @Override
    public String toString() {
        return "Project{" + "id='" + id + '\'' + ", description='" + description + '\'' + ", price=" + price + ", techlead=" + techlead + '}';
    }
}
