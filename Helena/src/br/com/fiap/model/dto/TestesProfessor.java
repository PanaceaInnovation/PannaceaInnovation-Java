package br.com.fiap.model.dto;

public class TestesProfessor extends TesteDTO{
    public TestesProfessor(){}

    public String[] testes(){
        return super.getTestes();
    }
}
