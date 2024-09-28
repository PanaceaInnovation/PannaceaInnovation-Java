package br.com.fiap.model.dto;

public class RevisarDTO {
    private String[] materiasRevisar = {
        "Anatomia e Fisiologia Aplicadas à Laparoscopia",
        "Fundamentos da Cirurgia Laparoscópica",
        "Equipamentos e Instrumentação",
        "Técnicas Básicas de Laparoscopia"
    };

    public RevisarDTO() {}

    public String[] getMateriasRevisar() {
        return materiasRevisar;
    }

    public void setMateriasRevisar(String[] materiasRevisar) {
        this.materiasRevisar = materiasRevisar;
    }
}
