package br.com.fiap.controller;

import br.com.fiap.model.dto.TesteDTO;

public class TesteController {
    private TesteDTO testes;

    public TesteController(){
        testes = new TesteDTO();
    }

    public String[] getTestes() {
        return testes.getTestes();
    }

// Proxima implementação de testes: Fazer com que o professor adicione o status do teste para cada aluno

    public String mostrarTestes(int opcao){
        switch (opcao) {
            case 0:
                return "Procedimentos Laparoscópicos Comuns\n" + 
                        "Avaliação 1: Concluída - Avaliação 2: Pendente - Avaliação 3: Pendente";
            case 1:
                return "Complicações e Gestão de Riscos\n" +
                        "Avaliação 1: Pendente - Avaliação 2: Pendente - Avaliação 3: Pendente";
            case 2:
                return "Treinamento em Simuladores e Prática em Laboratório\n" +
                        "Avaliação 1: Concluída - Avaliação 2: Concluída - Avaliação 3: Pendente";
                 
            default:
                return "Escolha incorreta";
        }
    }
}
