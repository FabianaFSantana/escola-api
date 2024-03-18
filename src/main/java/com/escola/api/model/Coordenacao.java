package com.escola.api.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "coordenacao")

public class Coordenacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCoordenacao;

    @Embedded
    private Usuario usuarioCoordenador;

    private String area;

}
