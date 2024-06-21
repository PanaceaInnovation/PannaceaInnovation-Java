package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Teste {
    private String[] testes = {"Procedimentos Laparoscópicos Comuns", "Complicações e Gestão de Riscos", "Treinamento em Simuladores e Prática em Laboratório"};

    public String[] getTestes() {
        return testes;
    }
    public void setTestes(String[] testes) {
        this.testes = testes;
    }

    public String mostrarTestes(){
        int opcao = JOptionPane.showOptionDialog(null, "Selecione um Psicologo para se conectar","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, testes, testes[0]);

        switch (opcao) {
            case 0:
                String teste1 = "Avaliação 1: Concluída - Avaliação 2: Pendente - Avaliação 3: Pendente";
                return teste1;
            case 1:
                String teste2 = "Avaliação 1: Pendente - Avaliação 2: Pendente - Avaliação 3: Pendente";
                return teste2;
            case 2:
                String teste3 = "Avaliação 1: Concluída - Avaliação 2: Concluída - Avaliação 3: Pendente";
                return teste3;
            default:
                String erro = "Escolha incorreta";
                return erro;
        }
    }
}
