package com.escola.api.controller;
import com.escola.api.model.Comunicado;
import com.escola.api.repository.ComunicadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comunicado")
public class ComunicadoController {
    @Autowired
    private ComunicadoRepository comunicadoRepository;

    @PostMapping
    public ResponseEntity<Comunicado> cadastrarComunicado(@RequestBody Comunicado comunicado) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(comunicadoRepository.save(comunicado));
    }


    @GetMapping
    public ResponseEntity<List<Comunicado>> comunicado() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(comunicadoRepository.findAll());
    }

    @GetMapping("/{idComunidado}")
    public ResponseEntity<Optional<Comunicado>> buscarComunicadoPeloId(@PathVariable("idComunicado") Long idComunidado) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(comunicadoRepository.findById(idComunidado));

    }


    @PutMapping("/{idComunicado}")
    public ResponseEntity<Comunicado> atualizarDadosComunicado(@PathVariable("idComunicado") Long idComunicado, @RequestBody Comunicado comunicado) {
        Optional<Comunicado> comunicadoOptional = comunicadoRepository.findById(idComunicado);

        if (comunicadoOptional.isPresent()) {
            Comunicado comunicadoAtualizado = comunicadoOptional.get();

            comunicadoAtualizado.setDescricao(comunicado.getDescricao());
            comunicadoAtualizado.setConfirmacaoleitura(comunicado.isConfirmacaoleitura());
            comunicadoAtualizado.setDataComunicado(comunicado.getDataComunicado());


            return ResponseEntity.status(HttpStatus.OK)
                    .body(comunicadoRepository.save(comunicadoAtualizado));

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/{idComunicado}")
    public ResponseEntity<String> excluirComunicado(@PathVariable("idComunicado") Long idComunicado) {
        comunicadoRepository.deleteById(idComunicado);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Comunicado removido com sucesso!");
    }
}





