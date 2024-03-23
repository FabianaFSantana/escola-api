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

import com.escola.api.model.Disciplina;
import com.escola.api.model.Professor;
import com.escola.api.model.Turma;
import com.escola.api.repository.DisciplinaRepository;
import com.escola.api.repository.ProfessorRepository;
import com.escola.api.repository.TurmaRepository;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

   @Autowired
   private ProfessorRepository professorRepository;

   @Autowired
   private DisciplinaRepository discipinaRepository;

   @PostMapping ("/professor")
   public ResponseEntity<Professor> cadastrarProfessor(@RequestBody Professor professor) {                                  
       return ResponseEntity.status(HttpStatus.CREATED)
       .body(professorRepository.save(professor));
   }

   @PostMapping("/{idProfessor}/adicionarDisciplinas/{idDisciplina}")
   public ResponseEntity<Professor> adicionarDisciplinas(@PathVariable("idProfessor") Long idProfessor,
   @PathVariable("idDisciplina") Long idDisciplina) {

      Optional<Professor> profOptional = professorRepository.findById(idProfessor);

      if (profOptional.isPresent()) {
         Professor profEncontrado = profOptional.get();

         Optional<Disciplina> disciplinaOptional =discipinaRepository.findById(idDisciplina);

         if (disciplinaOptional.isPresent()) {
            Disciplina disciplinaEsncontrada = disciplinaOptional.get();

            List<Disciplina> disciplinas = profEncontrado.getDisciplinas();
            disciplinas.add(disciplinaEsncontrada);

            professorRepository.save(profEncontrado);
            return ResponseEntity.ok(profEncontrado); 
         } else {
            return ResponseEntity.notFound().build();
         }
      }
      return ResponseEntity.notFound().build();
   }

   @GetMapping
   public ResponseEntity<List<Professor>> exibirListaDeProfessores() {
      return ResponseEntity.status(HttpStatus.OK)
      .body(professorRepository.findAll());
   }

   @GetMapping("/{id}")
   public ResponseEntity<Optional<Professor>> exibirProfessorPeloUsuario(@PathVariable("id") Long id) {
      return ResponseEntity.status(HttpStatus.OK)
      .body(professorRepository.findById(id));
   }

   @PutMapping("/{id}")
   public ResponseEntity<Professor> atualizarDadosProfessor(@PathVariable("id") Long id,
   @RequestBody Professor professor) {

      Optional<Professor> profOptional = professorRepository.findById(id);

      if (profOptional.isPresent()) {
         Professor profEncontrado = profOptional.get();

         profEncontrado.getUsuarioProfessor().setNome(professor.getUsuarioProfessor().getNome());
         profEncontrado.getUsuarioProfessor().setDataDeNascimento(professor.getUsuarioProfessor().getDataDeNascimento());
         profEncontrado.getUsuarioProfessor().setEmail(professor.getUsuarioProfessor().getEmail());
         profEncontrado.getUsuarioProfessor().setTelefone(professor.getUsuarioProfessor().getTelefone());
         

         return ResponseEntity.status(HttpStatus.OK)
         .body(professorRepository.save(profEncontrado));
         
      }
      return ResponseEntity.notFound().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<String> excluirProfessor(@PathVariable("id") Long id) {
      professorRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.OK)
      .body("Professor excluído com sucesso!");
   }
   
 



}