package com.example.assignment.repo;

import com.example.assignment.entity.custom.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    @Transactional
    @Modifying
    @Query("update Project p set p.description = ?1, p.price = ?2 where p.id = ?3")
    void updateDescriptionAndPriceById(String description, Double price, String id);

    Project save(Project entity);

    Project getProjectById(String id);

}
