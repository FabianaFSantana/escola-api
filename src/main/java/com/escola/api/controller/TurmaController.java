package com.escola.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.api.model.Aluno;
import com.escola.api.model.Turma;
import com.escola.api.repository.AlunoRepository;
import com.escola.api.repository.TurmaRepository;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    
    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<Turma> cadastrarTurma(@RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(turmaRepository.save(turma));
    }

    @PostMapping("/{idTurma}/adicionarAluno/{idAluno}")
    public ResponseEntity<Turma> adicionarAlunoNaTurma(@PathVariable("idTurma") Long idTurma,
    @PathVariable("idAluno") Long idAluno) {
        Optional<Turma> turmOptional = turmaRepository.findById(idTurma);

        if (turmOptional.isPresent()) {
            Turma turmaEncontrada = turmOptional.get();

            Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);

            if (alunoOptional.isPresent()) {
                Aluno alunoEncontrado = alunoOptional.get();

                List<Aluno> alunos = turmaEncontrada.getAlunos();
                alunos.add(alunoEncontrado);

                turmaRepository.save(turmaEncontrada);

                return ResponseEntity.ok(turmaEncontrada);
                
            } else {
                return ResponseEntity.notFound().build();
            }
            
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Turma>> exibirListaDeTurmas() {
        return ResponseEntity.status(HttpStatus.OK)
        .body(turmaRepository.findAll());
    }

    @GetMapping("/{idTurma}")
    public ResponseEntity<Optional<Turma>> localizarTurmaPeloId(@PathVariable("idTurma") Long idTurma) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(turmaRepository.findById(idTurma));
    }

    @PutMapping("/{idTurma}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable("idTurma") Long idTurma, @RequestBody Turma turma) {
        Optional<Turma> turmaOptional = turmaRepository.findById(idTurma);

        if (turmaOptional.isPresent()) {
            Turma turmaEncontrada =  turmaOptional.get();

            turmaEncontrada.setNomeDaTurma(turma.getNomeDaTurma());
            turmaEncontrada.setTurno(turma.getTurno());

            

            return ResponseEntity.status(HttpStatus.OK)
            .body(turmaRepository.save(turmaEncontrada));
            
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idTurma}")
    public ResponseEntity<String> excluirTurma(@PathVariable("idTurma") Long idTurma) {
        turmaRepository.deleteById(idTurma);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Turma excluída com sucesso!");
    }
}
