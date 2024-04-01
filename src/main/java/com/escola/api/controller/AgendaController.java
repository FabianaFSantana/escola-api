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

import com.escola.api.model.Agenda;
import com.escola.api.repository.AgendaRepository;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

    @PostMapping
    public ResponseEntity<Agenda> cadastrarAgendaDoDia(@RequestBody Agenda agenda) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(agendaRepository.save(agenda));
    }

 
    @GetMapping
    public ResponseEntity<List<Agenda>> exibirListaDeAgendas() {
        return ResponseEntity.status(HttpStatus.OK)
        .body(agendaRepository.findAll());
    }

    @GetMapping("/{idAgenda}")
    public ResponseEntity<Optional<Agenda>> exibirAgendaPeloId(@PathVariable("idAgenda") Long idAgenda) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(agendaRepository.findById(idAgenda));
    }

    @PutMapping("/{idAgenda}")
    public ResponseEntity<Agenda> atualizarAgenda(@PathVariable("idAgenda") Long idAgenda,
    @RequestBody Agenda agenda) {
        Optional<Agenda> agendOptional = agendaRepository.findById(idAgenda);

        if (agendOptional.isPresent()) {
            Agenda agendaEncont = agendOptional.get();

            agendaEncont.setData(agenda.getData());
            agendaEncont.setConteudoDaAula(agenda.getConteudoDaAula());
            agendaEncont.setAtividadeDeCasa(agenda.getAtividadeDeCasa());

            return ResponseEntity.status(HttpStatus.OK)
            .body(agendaRepository.save(agendaEncont));
            
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idAgenda}")
    public ResponseEntity<String> excluirAgenda(@PathVariable("idAgenda") Long idAgenda) {
        agendaRepository.deleteById(idAgenda);
        return ResponseEntity.status(HttpStatus.OK)
        .body("Agenda excluída com sucesso!");
    }
    
}
