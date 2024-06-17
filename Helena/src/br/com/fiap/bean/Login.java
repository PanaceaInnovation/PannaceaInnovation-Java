package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Login extends Cadastro {

    public boolean validaLogin(int matricula, String senha){
        try {
            if(matricula == getMatricula() && senha.equals(getSenha())){
                return true;
            }else{
                throw new Exception("CREDENCIAIS INVÁLIDAS!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
            return false;
        }
    }
}
