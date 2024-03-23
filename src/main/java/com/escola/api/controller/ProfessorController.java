package com.escola.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

   
   
 



}