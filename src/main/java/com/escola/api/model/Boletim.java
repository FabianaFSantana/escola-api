package com.escola.api.model;

import jakarta.persistence.Column;
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
@Entity(name = "boletim")

public class Boletim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBoletim;

    @Column(nullable = false)
    private double nota1;

    @Column(nullable = false)
    private double nota2;
    private boolean resultado;
}
