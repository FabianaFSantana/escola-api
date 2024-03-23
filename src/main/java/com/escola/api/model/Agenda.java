package com.escola.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    private Long id;
    private String data;
    private String disciplina;
    private String conteudoAula;
    private String atividadeCasa;

    public Agenda() {

    }

    public Agenda(String data, String disciplina, String conteudoAula, String atividadeCasa){  
    this.data = data;
    this.disciplina = disciplina;
    this.conteudoAula = conteudoAula;
    this.atividadeCasa = atividadeCasa;

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getConteudoAula() {
        return conteudoAula;
    }

    public void setConteudoAula(String conteudoAula) {
        this.conteudoAula = conteudoAula;
    }

    public String getAtividadeCasa() {
        return atividadeCasa;
    }

    public void setAtividadeCasa(String atividadeCasa) {
        this.atividadeCasa = atividadeCasa;
    }

    @Override
    public String toString() {
        return "Agenda{" +
               "id=" + id +
               ", data =' " + data + '\'' +
               ", disciplina =' " + disciplina + '\'' +
               ", conteudoAula = '" + conteudoAula + '\'' +
               ", atividadeCasa =' " + atividadeCasa + '\'' +
               '}';
    

        }
    }
