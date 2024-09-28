package br.com.fiap.controller;

import br.com.fiap.model.dto.TestesProfessorDTO;

public class TestesProfessorController {
    private TestesProfessorDTO testesProfessor;

    public TestesProfessorController(){
        testesProfessor = new TestesProfessorDTO();
    }

    public String[] getTestes() {
        return testesProfessor.testes();
    }

    public String mostrarTestesProfessor(int opcaoTeste){
        return testesProfessor.getTestesAlunos(opcaoTeste);
    }

}
