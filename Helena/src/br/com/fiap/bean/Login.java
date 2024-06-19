package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Login extends Cadastro {

    public Login(){}

    public boolean validaLogin(int lgMatricula, String lgSenha){
        if(lgMatricula == super.getMatricula() && lgSenha.equals(super.getSenha())){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "CREDENCIAIS INVÁLIDAS!");
            return false;
        }
    }
}
