package br.com.fiap.bean;


public class Login{

    private int verificaMatricula; 
    private String verificaSenha; 

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
            return false;
        }
    }
}
