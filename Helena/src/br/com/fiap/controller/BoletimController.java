package br.com.fiap.controller;

import javax.swing.JOptionPane;

import br.com.fiap.model.dto.BoletimDTO;

public class BoletimController {
    private BoletimDTO boletim;

    public BoletimController() {
        boletim = new BoletimDTO();
    }

    public String mostrarBoletim() {
        String[] materias = boletim.getMaterias();
        int opcao = JOptionPane.showOptionDialog(null, "Bem vindo a Helena, escolha uma opção para continuar","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, materias, materias[0]);

        switch (opcao) {
            case 0:
                return "Anatomia e Fisiologia Aplicadas à Laparoscopia\n" + "1ª Avaliação: 9.0 - " + "2ª Avaliação: 5.0" + " - 3ª Avaliação: 7.5";
            case 1:
                return "Fundamentos da Cirurgia Laparoscópica\n" + "1ª Avaliação: 7.0 - " + "2ª Avaliação: 8.0" + " - 3ª Avaliação: 8.5";
            case 2:
                return "Equipamentos e Instrumentação\n" + "1ª Avaliação: 4.5 - " + "2ª Avaliação: 9.0" + " - 3ª Avaliação: 6.5";
            case 3:
                return "Técnicas Básicas de Laparoscopia\n" + "1ª Avaliação: 9.0 - " + "2ª Avaliação: 7.0" + " - 3ª Avaliação: 7.5";
            default:
                return "Escolha incorreta";
        }
    }
}
