package com.escola.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 



}