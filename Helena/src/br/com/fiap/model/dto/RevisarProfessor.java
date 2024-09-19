package br.com.fiap.model.dto;

import javax.swing.JOptionPane;

public class RevisarProfessor extends Revisar {
    public RevisarProfessor() {}

    // Método para retornar as matérias
    public String[] materias() {
        return super.getMateriasRevisar();
    }

    // Método para retornar o status de revisão dos alunos em cada matéria
    public String mostrarRevisaoProfessor() {
        int opcao = JOptionPane.showOptionDialog(null, "Selecione uma matéria para ver o status de revisão dos alunos", "Revisão dos Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, materias(), materias()[0]);

        switch (opcao) {
            case 0:
                String materia1 = ("Status de Revisão dos alunos em Anatomia e Fisiologia Aplicadas à Laparoscopia\n" + 
                                   "Vitor Hugo: Pendente - Felipe Arnus: Em Progresso - Leticia Resina: Concluída - João Vieira: Pendente - João Chambrone: Concluída");
                return materia1;

            case 1:
                String materia2 = ("Status de Revisão dos alunos em Fundamentos da Cirurgia Laparoscópica\n" + 
                                   "Vitor Hugo: Concluída - Felipe Arnus: Pendente - Leticia Resina: Concluída - João Vieira: Em Progresso - João Chambrone: Pendente");
                return materia2;

            case 2:
                String materia3 = ("Status de Revisão dos alunos em Equipamentos e Instrumentação\n" + 
                                   "Vitor Hugo: Em Progresso - Felipe Arnus: Pendente - Leticia Resina: Concluída - João Vieira: Pendente - João Chambrone: Em Progresso");
                return materia3;

            case 3:
                String materia4 = ("Status de Revisão dos alunos em Técnicas Básicas de Laparoscopia\n" + 
                                   "Vitor Hugo: Concluída - Felipe Arnus: Concluída - Leticia Resina: Em Progresso - João Vieira: Pendente - João Chambrone: Concluída");
                return materia4;

            default:
                return "Escolha incorreta";
        }
    }
}