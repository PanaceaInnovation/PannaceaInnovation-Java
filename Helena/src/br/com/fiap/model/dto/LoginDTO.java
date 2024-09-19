package br.com.fiap.model.dto;


public class LoginDTO{

    private int matricula;
    private String senha;

    // Construtor
    public LoginDTO() {}

    public LoginDTO(int matricula, String senha) {
        this.matricula = matricula;
        this.senha = senha;
    }

    // Getters & Setters
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

