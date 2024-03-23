package com.escola.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.api.dto.MediaDto;
import com.escola.api.model.Boletim;
import com.escola.api.repository.BoletimRepository;

@Service
public class BoletimService {
    @Autowired
    private BoletimRepository boletimRepository;

     //Método para calcular média do aluno:

     public Double calcularMedia(Long idBoletim, MediaDto mediaDto) {
        Optional<Boletim> bOptional = boletimRepository.findById(idBoletim);

        if (bOptional.isPresent()) {
            Boletim boletimEncontrado = bOptional.get();

            mediaDto.setNota1(boletimEncontrado.getNota1());
            mediaDto.setNota2(boletimEncontrado.getNota2());

            Double novaMedia = (mediaDto.getNota1() + mediaDto.getNota2()) / 2;
            boletimEncontrado.setMedia(novaMedia);

            if (novaMedia >= 7) {
                boletimEncontrado.setResultado("aprovado");
            } else {
                boletimEncontrado.setResultado("Recuperação");
            }

            boletimRepository.save(boletimEncontrado);

            return novaMedia;

        } else {
            return null;
        }

    } 

}

   
