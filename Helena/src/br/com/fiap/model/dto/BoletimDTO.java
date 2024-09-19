package br.com.fiap.model.dto;


public class BoletimDTO {
    private String[] materias = {"Anatomia e Fisiologia Aplicadas à Laparoscopia", "Fundamentos da Cirurgia Laparoscópica", "\nEquipamentos e Instrumentação", "Técnicas Básicas de Laparoscopia"};
    public BoletimDTO(){}

    public String[] getMaterias() {
        return materias;
    }
    public void setMaterias(String[] materias) {
        this.materias = materias;
    }
}
