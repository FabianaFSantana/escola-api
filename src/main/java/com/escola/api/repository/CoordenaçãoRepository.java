package com.escola.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.model.Coordenacao;

@Repository
public interface CoordenaçãoRepository extends JpaRepository<Coordenacao, Long> {

    
}
