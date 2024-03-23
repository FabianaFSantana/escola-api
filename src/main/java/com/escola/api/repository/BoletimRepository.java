package com.escola.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.model.Boletim;
@Repository
public interface BoletimRepository extends JpaRepository<Boletim, Long> {
    
}
