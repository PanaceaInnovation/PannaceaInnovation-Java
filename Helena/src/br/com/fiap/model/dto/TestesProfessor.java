package br.com.fiap.model.dto;

public class TestesProfessor extends Teste{
    public TestesProfessor(){}

    public String[] testes(){
        return super.getTestes();
    }
}