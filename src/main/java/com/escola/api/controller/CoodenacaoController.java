package com.escola.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{idCoordenacao}")
    public ResponseEntity<Optional<Coordenacao>> buscarCoordenadorPeloId(@PathVariable("idCoordenacao") Long idCoordenacao) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(coordenacaoRepository.findById(idCoordenacao));
    }

    @PutMapping("/{idCoordenacao}")
    public ResponseEntity<Coordenacao> atualizarDadosDoCoordenador(@PathVariable("idCoordenacao") Long idCoordenacao,
    @RequestBody Coordenacao coordenacao) {
        Optional<Coordenacao> coordOptional = coordenacaoRepository.findById(idCoordenacao);

        if (coordOptional.isPresent()) {
            Coordenacao coordenadorEscontrado = coordOptional.get();

            coordenadorEscontrado.getUsuarioCoordenador().setNome(coordenacao.getUsuarioCoordenador().getNome());
            coordenadorEscontrado.getUsuarioCoordenador().setDataDeNascimento(coordenacao.getUsuarioCoordenador().getDataDeNascimento());
            coordenadorEscontrado.getUsuarioCoordenador().setEmail(coordenacao.getUsuarioCoordenador().getEmail());
            coordenadorEscontrado.getUsuarioCoordenador().setTelefone(coordenacao.getUsuarioCoordenador().getTelefone());
            coordenadorEscontrado.setArea(coordenacao.getArea());

            return ResponseEntity.status(HttpStatus.OK)
            .body(coordenacaoRepository.save(coordenadorEscontrado));
            
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
