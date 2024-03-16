package com.esolca.api.repository;

import com.esolca.api.model.Comunicado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunicadoRepository extends JpaRepository<Comunicado, Long>{



}
