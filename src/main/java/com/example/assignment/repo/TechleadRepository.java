package com.example.assignment.repo;

import com.example.assignment.entity.custom.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TechleadRepository extends JpaRepository<TechLead, String> {
    TechLead getTechLeadById(String id);

    @Transactional
    @Modifying
    @Query("update TechLead t set t.name = ?1, t.salary = ?2 where t.id = ?3")
    void updateNameSalaryById(String name, Double salary, String id);

}
