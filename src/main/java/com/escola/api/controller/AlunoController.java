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

import com.escola.api.model.Agenda;
import com.escola.api.model.Aluno;
import com.escola.api.repository.AlunoRepository;
import com.escola.api.service.AgendaService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(alunoRepository.save(aluno));
    }

    @PostMapping("/{idAluno}/associarAlunoAgenda/{idAgenda}")
    public ResponseEntity<String> associarAlunoAgenda(@PathVariable("idAluno") Long idAluno,
    @PathVariable("idAgenda") Long idAgenda) {

        agendaService.associarAgendaAluno(idAluno, idAgenda);
        return ResponseEntity.status(HttpStatus.OK)
        .body("Aluno associado a agenda com sucesso!");
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

    @GetMapping("/agendas")
    public ResponseEntity<List<Agenda>> mostrarAgendasDisponiveisParaOsAlunos() {
        List<Agenda> agendas = agendaService.listarAgendasDisponíveisParaAluno();
        return ResponseEntity.ok(agendas);
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

    @DeleteMapping("/{idAluno}")
    public ResponseEntity<String> excluirAluno(@PathVariable("idAluno") Long idAluno) {
        alunoRepository.deleteById(idAluno);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Aluno removido com sucesso!");
    }

    
    
}
