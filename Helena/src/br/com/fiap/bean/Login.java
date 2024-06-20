package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Login extends Cadastro {

    private int verificaMatricula; // Colocar no modelo uml
    private String verificaSenha; // Colocar no modelo uml

    public Login(){}

    public int getVerificaMatricula() {
        return verificaMatricula;
    }
    public void setVerificaMatricula(int verificaMatricula) {
        this.verificaMatricula = verificaMatricula;
    }

    public String getVerificaSenha() {
        return verificaSenha;
    }
    public void setVerificaSenha(String verificaSenha) {
        this.verificaSenha = verificaSenha;
    }

    public boolean validaLogin(int lgMatricula, String lgSenha){
        if(lgMatricula == getVerificaMatricula() && lgSenha.equals(getVerificaSenha())){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "CREDENCIAIS INVÁLIDAS!");
            return false;
        }
    }
}
