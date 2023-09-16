package com.example.assignment.repo;

import com.example.assignment.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,String> {
   Project save(Project entity);


}
