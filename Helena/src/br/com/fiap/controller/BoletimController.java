package br.com.fiap.controller;

import br.com.fiap.model.dto.BoletimDTO;

public class BoletimController {
    private BoletimDTO boletim;

    public BoletimController() {
        boletim = new BoletimDTO();
    }

    public String[] getMaterias() {
        return boletim.getMaterias();
    }

// Proxima implementação de boletiim: Fazer com que o professor adicione as notas para cada aluno

    public String mostrarBoletim(int opcao) {
        switch (opcao) {
            case 0:
                return "Anatomia e Fisiologia Aplicadas à Laparoscopia\n" +
                        "1ª Avaliação: 9.0 - 2ª Avaliação: 5.0 - 3ª Avaliação: 7.5";
            case 1:
                return "Fundamentos da Cirurgia Laparoscópica\n" +
                        "1ª Avaliação: 7.0 - 2ª Avaliação: 8.0 - 3ª Avaliação: 8.5";
            case 2:
                return "Equipamentos e Instrumentação\n" +
                        "1ª Avaliação: 4.5 - 2ª Avaliação: 9.0 - 3ª Avaliação: 6.5";
            case 3:
                return "Técnicas Básicas de Laparoscopia\n" +
                        "1ª Avaliação: 9.0 - 2ª Avaliação: 7.0 - 3ª Avaliação: 7.5";
            default:
                return "Escolha incorreta";
        }
    }

}
