package br.com.fiap.controller;

import br.com.fiap.model.dto.BoletimProfessor;

public class BoletimProfessorController {
    private BoletimProfessor boletimProfessor;

    public BoletimProfessorController() {
        boletimProfessor = new BoletimProfessor();
    }

    public String[] getMaterias() {
        return boletimProfessor.materias();
    }

    // Método para o professor ver as notas dos alunos
    public String mostrarBoletimProfessor(int opcaoMateria) {
        return boletimProfessor.getMediaAlunos(opcaoMateria);
    }
}