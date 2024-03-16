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
@Entity(name = "turma")

public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTurma;

    @Column(nullable = false, unique = true)
    private String nomeDaTurma;


}
