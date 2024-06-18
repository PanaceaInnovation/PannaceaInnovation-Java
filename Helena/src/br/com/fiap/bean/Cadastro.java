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
    private Boolean autoridade; // Colocar no modelo UML

    // Constructor (Usar o set para definir o constructor SEMPRE que tiver uma condição para atribuir a variavel)

    public Cadastro(String nome, String apelido, String cpf, int matricula, String email, String senha, Boolean autoridade){
        this.nome = nome;
        this.apelido = apelido;
        setCpf(cpf);
        setMatricula(matricula);
        this.email = email;
        this.senha = senha;
        this.autoridade = autoridade;
    }

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
                this.matricula = matricula;
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

    public Boolean getAutoridade() {
        return autoridade;
    }
    public void setAutoridade(Boolean autoridade) {
        if(validaAutoridade(matricula)){
            this.autoridade = true;
        }else{
            this.autoridade = false;
        }
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

    public boolean validaAutoridade(int matricula){ // COLOCAR ISSO NO MODELO UML
        if(matricula >= 40000 && matricula <= 60000){
            return true;
        }else{
            return false;
        }
    }
}
