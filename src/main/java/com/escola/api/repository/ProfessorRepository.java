package com.escola.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
}
