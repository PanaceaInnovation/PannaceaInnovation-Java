package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Login extends Cadastro {
    public Login(String nome, String apelido, String cpf, int matricula, String email, String senha, Boolean autoridade) {
        super(nome, apelido, cpf, matricula, email, senha, autoridade);
    }

    public boolean validaLogin(int matricula, String senha){
        try {
            if(matricula == super.getMatricula() && senha.equals(super.getSenha())){
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
