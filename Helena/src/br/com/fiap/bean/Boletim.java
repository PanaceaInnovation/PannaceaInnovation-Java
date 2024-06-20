package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Boletim {
    String[] materias = {"Anatomia e Fisiologia Aplicadas à Laparoscopia", "Fundamentos da Cirurgia Laparoscópica", "\nEquipamentos e Instrumentação", "Técnicas Básicas de Laparoscopia"};
    public Boletim(){}

    public String mostrarBoletim(){
        int opcao = JOptionPane.showOptionDialog(null, "Bem vindo a Helena, escolha uma opção para continuar","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, materias, materias[0]);

        switch (opcao) {
            case 0:
                String notaMateria1 = ("Anatomia e Fisiologia Aplicadas à Laparoscopia\n" + "1ª Avaliação: 9.0 - " + "2ª Avaliação 2: 5.0" + " - 3ª Avaliação 3: 7.5");
                return notaMateria1;
            case 1:
                String notaMateria2 = "Fundamentos da Cirurgia Laparoscópica\n" + "1ª Avaliação: 7.0 - " + "2ª Avaliação: 8.0" + " - 3ª Avaliação: 8.5";
                return notaMateria2;
            case 2:
                String notaMateria3 = "Equipamentos e Instrumentação\n" + "1ª Avaliação: 4.5 - " + "2ª Avaliação: 9.0" + " - 3ª Avaliação: 6.5";
                return notaMateria3;
            case 3:
                String notaMateria4 = "Técnicas Básicas de Laparoscopia\n" + "1ª Avaliação: 9.0 - " + "2ª Avaliação: 7.0" + " - 3ª Avaliação: 7.5";
                return notaMateria4;
            default:
                String erro = "Escolha incorreta";
                return erro;
        }
    }
}
