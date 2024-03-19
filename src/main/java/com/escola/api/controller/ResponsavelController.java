package com.escola.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.api.model.Responsavel;
import com.escola.api.repository.ResponsavelRepository;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @PostMapping
    public ResponseEntity<Responsavel> cadastrarResponsavel(@RequestBody Responsavel responsavel) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(responsavelRepository.save(responsavel));
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> listarResponsaveis() {
        return ResponseEntity.status(HttpStatus.OK)
        .body(responsavelRepository.findAll());
    }


    
}
