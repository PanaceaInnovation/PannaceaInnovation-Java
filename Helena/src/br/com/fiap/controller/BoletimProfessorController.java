package br.com.fiap.controller;

import br.com.fiap.model.dto.BoletimProfessorDTO;

public class BoletimProfessorController {
    private BoletimProfessorDTO boletimProfessor;

    public BoletimProfessorController() {
        boletimProfessor = new BoletimProfessorDTO();
    }

    public String[] getMaterias() {
        return boletimProfessor.materias();
    }

    public String mostrarBoletimProfessor(int opcaoMateria) {
        return boletimProfessor.getMediaAlunos(opcaoMateria);
    }
}