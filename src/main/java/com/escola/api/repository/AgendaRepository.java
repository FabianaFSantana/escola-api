package com.escola.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    
}
