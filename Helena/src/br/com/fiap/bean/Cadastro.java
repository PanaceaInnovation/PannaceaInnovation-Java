package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Cadastro {
    // Atributos
    private String nome;
    private String apelido;
    private String cpf;
    private int matricula;
    private String email;
    private String senha;

    //Getters & Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        try {
            if(validaCPF(cpf)){
                this.cpf = cpf;
            }else{
                throw new Exception("CPF INVÁLIDO: " + cpf);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }        
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        try {
            if(matricula >= 40000 && matricula <= 551999){
                this.matricula = matricula; // Fazer matricula faculdade aqui
            }else{
                throw new Exception("MATRÍCULA INVÁLIDO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean validaCPF(String cpf){
        if (cpf.length() != 11) {
            return false;
        }

        for (int i = 0; i < cpf.length(); i++) {
            if (!Character.isDigit(cpf.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
