package com.escola.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.api.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    
}
