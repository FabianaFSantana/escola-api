package com.esolca.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "comunicado")
public class Comunicado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComunicado;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate dataComunicado;
    private LocalDate data;
    private String descricao;
    private boolean confirmacaoleitura;





}
