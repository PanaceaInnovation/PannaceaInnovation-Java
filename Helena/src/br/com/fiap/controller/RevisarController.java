package br.com.fiap.controller;

import br.com.fiap.model.dto.RevisarDTO;

public class RevisarController {
    private RevisarDTO revisar;

    public RevisarController(){
        revisar = new RevisarDTO();
    }

    public String[] getRevisar() {
        return revisar.getMateriasRevisar();
    }

// Proxima implementação de testes: Fazer com que o professor adicione o status da revisão sugerida para cada aluno

    public String mostrarRevisao(int opcao){
        switch (opcao) {
            case 0:
                return "Anatomia e Fisiologia Aplicadas à Laparoscopia\n" + 
                        "Status da revisão: Em andamento";
            case 1:
                return "Fundamentos da Cirurgia Laparoscópica\n" +
                        "Status da revisão: Concluído";
            case 2:
                return "Equipamentos e Instrumentação\n" +
                        "Status da revisão: Pendente";
            case 3:
                return "Técnicas Básicas de Laparoscopia\n" +
                "Status da revisão: Pendente";
            default:
                return "Escolha incorreta";
        }
    }

}
