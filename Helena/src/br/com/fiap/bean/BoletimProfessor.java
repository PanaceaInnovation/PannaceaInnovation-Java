package br.com.fiap.bean;

public class BoletimProfessor extends Boletim {
    public BoletimProfessor(){}

    
    public String[] materias(){
        String[] materias = super.getMaterias();

        return materias;
    }


}
