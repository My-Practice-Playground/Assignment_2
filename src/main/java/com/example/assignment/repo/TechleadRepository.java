package com.example.assignment.repo;

import com.example.assignment.entity.custom.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechleadRepository extends JpaRepository<TechLead,String> {
}
