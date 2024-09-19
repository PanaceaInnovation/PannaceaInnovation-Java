package br.com.fiap.model.dto;

import javax.swing.JOptionPane;

public class Revisar {
    private String[] materiasRevisar = {
        "Anatomia e Fisiologia Aplicadas à Laparoscopia",
        "Fundamentos da Cirurgia Laparoscópica",
        "Equipamentos e Instrumentação",
        "Técnicas Básicas de Laparoscopia"
    };

    private String[] statusRevisao = {
        "Pendente",    
        "Concluída",  
        "Pendente",   
        "Em Progresso"
    };

    public Revisar() {}

    public String[] getMateriasRevisar() {
        return materiasRevisar;
    }

    public void setMateriasRevisar(String[] materiasRevisar) {
        this.materiasRevisar = materiasRevisar;
    }

    public String[] getStatusRevisao() {
        return statusRevisao;
    }

    public void setStatusRevisao(String[] statusRevisao) {
        this.statusRevisao = statusRevisao;
    }

    public String mostrarRevisao() {
        int opcao = JOptionPane.showOptionDialog(null, "Selecione uma matéria para revisar", "Revisão", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, materiasRevisar, materiasRevisar[0]);

        switch (opcao) {
            case 0:
                return materiasRevisar[0] + "\nStatus de Revisão: " + statusRevisao[0];
            case 1:
                return materiasRevisar[1] + "\nStatus de Revisão: " + statusRevisao[1];
            case 2:
                return materiasRevisar[2] + "\nStatus de Revisão: " + statusRevisao[2];
            case 3:
                return materiasRevisar[3] + "\nStatus de Revisão: " + statusRevisao[3];
            default:
                return "Escolha incorreta";
        }
    }
}
