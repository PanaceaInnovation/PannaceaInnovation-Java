package br.com.fiap.model.dto;

public class BoletimProfessor extends BoletimDTO {
    public BoletimProfessor(){}

    
    public String[] materias(){
        return super.getMaterias();
    }


}
