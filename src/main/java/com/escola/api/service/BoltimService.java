package com.escola.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.escola.api.dto.MediaDto;
import com.escola.api.model.Boletim;
import com.escola.api.repository.BoletimRepository;

public class BoltimService {
    @Autowired
    private BoletimRepository boletimRepository;

    //Método para calcular média do aluno:

   /*  public Double calcularMedia(Long idBoletim, MediaDto mediaDto) {
        Optional<Boletim> bOptional = boletimRepository.findById(idBoletim);

        if (bOptional.isPresent()) {
            Boletim boletimEncontrado = bOptional.get();


        }
    } */
}
