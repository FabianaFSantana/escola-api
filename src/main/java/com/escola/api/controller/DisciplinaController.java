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

import com.escola.api.model.Disciplina;
import com.escola.api.repository.DisciplinaRepository;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @PostMapping
    public ResponseEntity<Disciplina> cadastrarDisciplina(@RequestBody Disciplina disciplina) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(disciplinaRepository.save(disciplina));
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> exibirListaDasDisciplinas() {
        return ResponseEntity.status(HttpStatus.OK)
        .body(disciplinaRepository.findAll());
    }

    @GetMapping("/{idDisciplina}")
    public ResponseEntity<Optional<Disciplina>> buscarDisciplinaPeloId(@PathVariable("idDisciplina") Long idDisciplina) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(disciplinaRepository.findById(idDisciplina));
    }

    @PutMapping("/{idDisciplina}")
    public ResponseEntity<Disciplina> atualizarDadosDaDisciplina(@PathVariable("idDisciplina") Long idDisciplina,
    @RequestBody Disciplina disciplina) {
        Optional<Disciplina> discipOptional = disciplinaRepository.findById(idDisciplina);
        
        if (discipOptional.isPresent()) {
            Disciplina discipEncontrada = discipOptional.get();

            discipEncontrada.setNomeDisciplina(disciplina.getNomeDisciplina());

            return ResponseEntity.status(HttpStatus.OK)
            .body(disciplinaRepository.save(discipEncontrada));

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //MÉTODO PARA DELETAR: 
    @DeleteMapping("/{idDisciplina}")
    public ResponseEntity<String> excluirDisciplina(@PathVariable("idDisciplina") Long idDisciplina) {
        disciplinaRepository.deleteById(idDisciplina);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Disciplina DELETADA!");
    }

    @DeleteMapping
    public ResponseEntity<String> excluirTodasDisciplinas() {
        disciplinaRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body("Todas disciplinas canceladas.");
    }

    


    
}
