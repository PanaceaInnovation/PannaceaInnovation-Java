package br.com.fiap.model.dto;


public class TesteDTO {
    private String[] testes = {"Procedimentos Laparoscópicos Comuns", "Complicações e Gestão de Riscos", "Treinamento em Simuladores e Prática em Laboratório"};

    public TesteDTO(){}

    public String[] getTestes() {
        return testes;
    }
    public void setTestes(String[] testes) {
        this.testes = testes;
    }
}

