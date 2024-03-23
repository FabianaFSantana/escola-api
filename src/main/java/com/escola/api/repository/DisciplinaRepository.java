package com.escola.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.model.Disciplina;
@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    
}
