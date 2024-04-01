package com.escola.api.model;





import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "aluno")

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAluno;

    @Embedded
    private Usuario usuarioAluno;

    @Column(nullable = false, unique = true)
    private long matricula;

    @OneToMany
    private List<Agenda> agendAlunos;

 



   




}
