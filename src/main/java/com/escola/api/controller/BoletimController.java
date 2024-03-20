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

    @GetMapping
    public ResponseEntity<List<Boletim>> exbirListaDeBoletins() {
        return ResponseEntity.status(HttpStatus.OK)
        .body(boletimRepository.findAll());
    }

    @GetMapping("/{idBoletim}")
    public ResponseEntity<Optional<Boletim>> buscarBoletimPeloId(@PathVariable("idBoletim") Long idBoletim) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(boletimRepository.findById(idBoletim));
    }

    @PutMapping("/{idBoletim}")
    public ResponseEntity<Boletim> atualizarDadosDoBoletim(@PathVariable("idBoletim") Long idBoletim,
    @RequestBody Boletim boletim) {
        Optional<Boletim> boletimOptional = boletimRepository.findById(idBoletim);

        if (boletimOptional.isPresent()) {
            Boletim boletimEncontrado = boletimOptional.get();

            boletimEncontrado.setNota1(boletim.getNota1());
            boletimEncontrado.setNota2(boletim.getNota2());
            
            return ResponseEntity.status(HttpStatus.OK)
            .body(boletimRepository.save(boletimEncontrado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idBoletim}")
    public ResponseEntity<String> excluirBoletim(@PathVariable("idBoletim") Long idBoletim) {
        boletimRepository.deleteById(idBoletim);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Boletim excluído com sucesso!");

    }



    
}
