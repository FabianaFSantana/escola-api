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

import com.escola.api.model.Professor;
import com.escola.api.repository.ProfessorRepository;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

   @Autowired
   private ProfessorRepository professorRepository;

   @PostMapping ("/professor")
   public ResponseEntity<Professor> cadastrarProfessor(@RequestBody Professor professor) {                                  
       return ResponseEntity.status(HttpStatus.CREATED)
       .body(professorRepository.save(professor));
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
         profEncontrado.setDisciplina(professor.getDisciplina());

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