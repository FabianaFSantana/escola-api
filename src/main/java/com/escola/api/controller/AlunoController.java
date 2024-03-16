package com.escola.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.api.model.Aluno;
import com.escola.api.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(alunoRepository.save(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> alunos() {
        return ResponseEntity.status(HttpStatus.OK)
        .body(alunoRepository.findAll());
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity<Optional<Aluno>> buscarAlunoPeloId(@PathVariable("idAluno") Long idAluno) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(alunoRepository.findById(idAluno));
       
    }

    @PutMapping("/{idAluno}")
    public ResponseEntity<Aluno> atualizarDadosAluno(@PathVariable("idAluno") Long idAluno, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);

        if (alunoOptional.isPresent()) {
            Aluno alunoAtualizado = alunoOptional.get();

            alunoAtualizado.getUsuarioAluno().setNome(aluno.getUsuarioAluno().getNome());
            alunoAtualizado.getUsuarioAluno().setDataDeNascimento(aluno.getUsuarioAluno().getDataDeNascimento());
            alunoAtualizado.getUsuarioAluno().setEmail(aluno.getUsuarioAluno().getEmail());
            alunoAtualizado.getUsuarioAluno().setTelefone(aluno.getUsuarioAluno().getTelefone());
            alunoAtualizado.setMatricula(aluno.getMatricula());

            return ResponseEntity.status(HttpStatus.OK)
            .body(alunoRepository.save(alunoAtualizado));

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    
    
}
