package br.com.fiap.controller;

import br.com.fiap.model.dto.RevisarProfessorDTO;

public class RevisarProfessorController {
    private RevisarProfessorDTO revisarProfessor;

    public RevisarProfessorController(){
        revisarProfessor = new RevisarProfessorDTO();
    }

    public String[] getTestes() {
        return revisarProfessor.materias();
    }

    public String mostrarRevisoesProfessor(int opcaoRevisao){
        return revisarProfessor.getRevisoesAlunos(opcaoRevisao);
    }
}
