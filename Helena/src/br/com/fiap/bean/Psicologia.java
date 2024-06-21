package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Psicologia {
    private String[] psicologos = {"Dr. Laura Cardoso", "Dr. Rafael Mendes", "Dr. Mariana Ribeiro", "Dr. Gustavo Almeida"};

    public Psicologia(){}

    public String exibePsicologos(){
        int opcao = JOptionPane.showOptionDialog(null, "Selecione um Psicologo para se conectar","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, psicologos, psicologos[0]);

        switch (opcao) {
            case 0:
                String psi1 = "Conectando-se com Dr. Laura Cardoso";
                return psi1;
            case 1:
                String psi2 = "Conectando-se com Dr. Rafael Mendes";
                return psi2;
            case 2:
                String psi3 = "Conectando-se com Dr. Mariana Ribeiro";
                return psi3;
            case 3:
                String psi4 = "Conectando-se com Dr. Gustavo Almeida";
                return psi4;
            default:
                String erro = "Escolha incorreta";
                return erro;
        }
    }
}
