package br.com.fiap.model.dto;

public class TestesProfessorDTO extends TesteDTO{
    public TestesProfessorDTO(){}

    public String[] testes(){
        return super.getTestes();
    }

    public String getTestesAlunos(int opcaoTeste) {
        switch (opcaoTeste) {
            case 0:
                return "Testes dos alunos em Procedimentos Laparoscópicos Comuns\n" + "Vitor Hugo: A1: Concluído - A2: Concluído - A3: Concluído \nFelipe Arnus: A1: Pendente - A2: Pendente - A3: Concluído \nLeticia Resina: A1: Concluído - A2: Pendente - A3: Concluído \nJoão Vieira: A1: Pendente - A2: Pendente - A3: Concluído \nJoão Chambrone: A1: Concluído - A2: Concluído - A3: Pendente";
            case 1:
                return "Testes dos alunos em Complicações e Gestão de Riscos\n" 
                + "Vitor Hugo: A1: Concluído - A2: Concluído - A3: Concluído \nFelipe Arnus: A1: Pendente - A2: Pendente - A3: Concluído \nLeticia Resina: A1: Concluído - A2: Pendente - A3: Concluído \nJoão Vieira: A1: Pendente - A2: Pendente - A3: Concluído \nJoão Chambrone: A1: Concluído - A2: Concluído - A3: Pendente";
            case 2:
                return "Testes dos alunos em Treinamento em Simuladores e Prática em Laboratório\n" 
                + "Vitor Hugo: A1: Concluído - A2: Concluído - A3: Concluído \nFelipe Arnus: A1: Pendente - A2: Pendente - A3: Concluído \nLeticia Resina: A1: Concluído - A2: Pendente - A3: Concluído \nJoão Vieira: A1: Pendente - A2: Pendente - A3: Concluído \nJoão Chambrone: A1: Concluído - A2: Concluído - A3: Pendente";
            default:
                return "Escolha incorreta";
        }
    }
}
