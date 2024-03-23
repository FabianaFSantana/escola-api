package com.escola.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.api.model.Agenda;
import com.escola.api.repository.AgendaRepository;

@Service


public class AgendaService {
    @Autowired
    private static AgendaRepository agendaRepository;

    public static List<Agenda> getAllItems() {
        return agendaRepository.findAll();
    }
    public Optional<Agenda> getItemById(Long id) {
        return agendaRepository.findById(id);
    }

    public Agenda addItem(Agenda deleItem) {
       return agendaRepository.save(deleItem);
    }   

    public Agenda updateItem(Agenda agendaItem) {
       return agendaRepository.save(agendaItem);
    }   

    public Object deletItem(Long id) {
       return agendaRepository.findById(id);

    }  
    

}
