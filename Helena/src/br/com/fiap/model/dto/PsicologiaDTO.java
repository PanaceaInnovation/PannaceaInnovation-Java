package br.com.fiap.model.dto;

public class PsicologiaDTO {
    private String[] psicologos = {"Dr. Laura Cardoso", "Dr. Rafael Mendes", "Dr. Mariana Ribeiro", "Dr. Gustavo Almeida"};

    public PsicologiaDTO(){}

    public String[] getPsicologos() {
        return psicologos;
    }
    public void setPsicologos(String[] psicologos) {
        this.psicologos = psicologos;
    }
}
