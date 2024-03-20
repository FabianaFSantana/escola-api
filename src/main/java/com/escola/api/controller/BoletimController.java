package com.escola.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.api.model.Boletim;
import com.escola.api.repository.BoletimRepository;

@RestController
@RequestMapping("/boletim")
public class BoletimController {

    @Autowired
    private BoletimRepository boletimRepository;

    @PostMapping
    public ResponseEntity<Boletim> cadastarDadosNoBoletim(@RequestBody Boletim boletim) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(boletimRepository.save(boletim));
    }

    
}
