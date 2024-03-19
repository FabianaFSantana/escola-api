package com.escola.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    
    
}
