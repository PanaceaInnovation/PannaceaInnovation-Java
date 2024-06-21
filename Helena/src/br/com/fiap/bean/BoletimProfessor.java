package br.com.fiap.bean;

public class BoletimProfessor extends Boletim {
    public BoletimProfessor(){}

    
    public String[] Teste(){
        String[] teste1 = super.getMaterias();

        return teste1;
    }
}
