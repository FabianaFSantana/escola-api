package com.esolca.api.controller;

import com.esolca.api.model.Comunicado;
import com.esolca.api.repository.ComunicadoRepository;
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
}

    /*@GetMapping
    public ResponseEntity<List<Aluno>> alunos() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(alunoRepository.findAll());
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity<Optional<Aluno>> buscarAlunoPeloId(@PathVariable("idAluno") Long idAluno) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(alunoRepository.findById(idAluno));

    }

    @PutMapping("/{idAluno}")
    public ResponseEntity<Aluno> atualizarDadosAluno(@PathVariable("idAluno") Long idAluno, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);

        if (alunoOptional.isPresent()) {
            Aluno alunoAtualizado = alunoOptional.get();

            alunoAtualizado.getUsuarioAluno().setNome(aluno.getUsuarioAluno().getNome());
            alunoAtualizado.getUsuarioAluno().setDataDeNascimento(aluno.getUsuarioAluno().getDataDeNascimento());
            alunoAtualizado.getUsuarioAluno().setEmail(aluno.getUsuarioAluno().getEmail());
            alunoAtualizado.getUsuarioAluno().setTelefone(aluno.getUsuarioAluno().getTelefone());
            alunoAtualizado.setMatricula(aluno.getMatricula());

            return ResponseEntity.status(HttpStatus.OK)
                    .body(alunoRepository.save(alunoAtualizado));

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{idAluno}")
    public ResponseEntity<String> excluirAluno(@PathVariable("idAluno") Long idAluno) {
        alunoRepository.deleteById(idAluno);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Aluno removido com sucesso!");
    }





}
