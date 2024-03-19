package com.escola.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Responsavel>> buscarResponsavelPeloId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(responsavelRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> atualizarDadosDoResponsavel(@PathVariable("id") Long id,
    @RequestBody Responsavel responsavel) {
        Optional<Responsavel> respOptional = responsavelRepository.findById(id);

        if (respOptional.isPresent()) {
            Responsavel responsavelEncontrado = respOptional.get();

            responsavelEncontrado.getUsuarioResponsavel().setNome(responsavel.getUsuarioResponsavel().getNome());
            responsavelEncontrado.getUsuarioResponsavel().setDataDeNascimento(responsavel.getUsuarioResponsavel().getDataDeNascimento());
            responsavelEncontrado.getUsuarioResponsavel().setEmail(responsavel.getUsuarioResponsavel().getEmail());
            responsavelEncontrado.getUsuarioResponsavel().setTelefone(responsavel.getUsuarioResponsavel().getTelefone());
            responsavelEncontrado.setCpfResponsavel(responsavel.getCpfResponsavel());

            return ResponseEntity.status(HttpStatus.OK)
            .body(responsavelRepository.save(responsavelEncontrado));
            
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    
}
