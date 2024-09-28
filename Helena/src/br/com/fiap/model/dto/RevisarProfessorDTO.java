package br.com.fiap.model.dto;

public class RevisarProfessorDTO extends RevisarDTO {
    public RevisarProfessorDTO() {}

    public String[] materias() {
        return super.getMateriasRevisar();
    }

    public String getRevisoesAlunos(int opcaoRevisao) {

        switch (opcaoRevisao) {
            case 0:
                return "Status de Revisão dos alunos em Anatomia e Fisiologia Aplicadas à Laparoscopia\n" + 
                                   "Vitor Hugo: Pendente - Felipe Arnus: Em Progresso - Leticia Resina: Concluída - João Vieira: Pendente - João Chambrone: Concluída";
            case 1:
                return "Status de Revisão dos alunos em Fundamentos da Cirurgia Laparoscópica\n" + 
                                   "Vitor Hugo: Concluída - Felipe Arnus: Pendente - Leticia Resina: Concluída - João Vieira: Em Progresso - João Chambrone: Pendente";
            case 2:
                return "Status de Revisão dos alunos em Equipamentos e Instrumentação\n" + 
                                   "Vitor Hugo: Em Progresso - Felipe Arnus: Pendente - Leticia Resina: Concluída - João Vieira: Pendente - João Chambrone: Em Progresso";
            case 3:
                return "Status de Revisão dos alunos em Técnicas Básicas de Laparoscopia\n" + 
                                   "Vitor Hugo: Concluída - Felipe Arnus: Concluída - Leticia Resina: Em Progresso - João Vieira: Pendente - João Chambrone: Concluída";
            default:
                return "Escolha incorreta";
        }
    }
}