package com.escola.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.api.model.Agenda;
import com.escola.api.model.Aluno;
import com.escola.api.repository.AgendaRepository;
import com.escola.api.repository.AlunoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendaService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    public void associarAgendaAluno(Long idAluno, Long idAgenda) {

        Optional<Aluno> aluOptional = alunoRepository.findById(idAluno);
        if (aluOptional.isPresent()) {
            Aluno alunoEncont = aluOptional.get();

            Optional<Agenda> ageOptional = agendaRepository.findById(idAgenda);
            if (ageOptional.isPresent()) {
                Agenda agenda = ageOptional.get();

                List<Agenda> agendas = alunoEncont.getAgendAlunos();
                agendas.add(agenda);

                try {
                    alunoRepository.save(alunoEncont);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("Erro ao salva aluno associado à agenda.");
                }

                try {
                    agendaRepository.save(agenda);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("Erro ao salva agenda associado ao aluno.");
                }

                //O uso do RuntimeException se deve ao fato que o programa estava associando
                //o aluno à agenda, mas me retornava uma mensagem de erro como se o aluno
                //não houvesse sido encontrado.

                return;
                
                
            }
           
        }

        throw new RuntimeException("Erro ao associar aluno à agenda.");
        
    }

    
    
}
