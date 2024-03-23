package com.esolca.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esolca.api.model.Professor;
import com.esolca.api.repository.ProfessorRepository;

@Controller
@RestController
@RequestMapping ("/professor")
public class ProfessorController {

private Object professorRepository;
@SuppressWarnings("unchecked")
@PostMapping ("/salvarProfessor")
 public Professor cadastraProfessor(@RequestParam String nome, @RequestParam String disciplina) {     
    Professor professor =  cadastraProfessor(nome, disciplina);                               
       return ((CrudRepository<Professor, Long>) professorRepository).save(professor);
 }
 

@SuppressWarnings("unused")
@Autowired
private ProfessorRepository professoRepository;
}