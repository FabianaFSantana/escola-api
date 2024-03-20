package com.escola.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.escola.api.model.Boletim;
import com.escola.api.repository.BoletimRepository;

public class BoltimService {
    @Autowired
    private BoletimRepository boletimRepository;

     //Método para calcular média do aluno:

     public Double calcularMedia(Long idBoletim, Boletim nota1, Boletim nota2) {
        Optional<Boletim> bOptional = boletimRepository.findById(idBoletim);

        if (bOptional.isPresent()) {
            Boletim boletimEncontrado = bOptional.get();

            Double novaMedia = (boletimEncontrado.getNota1() + boletimEncontrado.getNota2()) / 2;
            boletimEncontrado.setMedia(novaMedia);

            boletimRepository.save(boletimEncontrado);

            return novaMedia;

        } else {
            return null;
        }

    } 

}

   
