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

import com.escola.api.model.Coordenacao;
import com.escola.api.repository.CoordenacaoRepository;

@RestController
@RequestMapping("/coordenacao")
public class CoodenacaoController {

    @Autowired
    private CoordenacaoRepository coordenacaoRepository;

    @PostMapping
    public ResponseEntity<Coordenacao> cadastrarCoordenador(@RequestBody Coordenacao coordenacao) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(coordenacaoRepository.save(coordenacao));
    }

    @GetMapping
    public ResponseEntity<List<Coordenacao>> listarCoordenadores() {
        return ResponseEntity.status(HttpStatus.OK)
        .body(coordenacaoRepository.findAll());

    }

    
}
