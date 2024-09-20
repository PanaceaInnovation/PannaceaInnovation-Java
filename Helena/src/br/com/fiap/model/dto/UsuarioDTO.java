package br.com.fiap.model.dto;

import javax.swing.JOptionPane;

public class UsuarioDTO{
    // Atributos
    private String nome;
    private String apelido;
    private String cpf;
    private int matricula;
    private String email;
    private String senha;
    private int autoridade; 

    // Constructor (Usar o set para definir o constructor SEMPRE que tiver uma condição para atribuir a variavel)
    public UsuarioDTO(){}

    public UsuarioDTO(String nome, String apelido, String cpf, int matricula, String email, String senha, int autoridade){
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
        }        
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        try {
            if(validaMatricula(matricula)){
                this.matricula = matricula;
            }else{
                throw new Exception("MATRÍCULA INVÁLIDO!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        try {
            if(validaSenha(senha)){
                this.senha = senha;
            }else{
                throw new Exception("SENHA DEVE SER MAIOR QUE 7 CARACTERES !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int getAutoridade() {
        return autoridade;
    }
    public void setAutoridade(int autoridade) {
        if(validaAutoridade(matricula)){
            this.autoridade = 1;
        }else{
            this.autoridade = 0;
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


    public boolean validaMatricula(int matricula){
        if(matricula >= 40000 && matricula <= 551999){
            return true;
        }else{
            return false;
        }
    }

    public boolean validaSenha(String senha){
        if(senha.length() >= 8){
            return true;
        }else{
            return false;
        }
    }

    public boolean validaAutoridade(int matricula){
        if(matricula >= 40000 && matricula <= 70000){
            return true;
        }else{
            return false;
        }
    }
}
