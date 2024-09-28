package br.com.fiap.controller;

import br.com.fiap.model.dto.PsicologiaDTO;

public class PsicologiaController {
    public PsicologiaDTO psicologos;

    public PsicologiaController(){
        psicologos = new PsicologiaDTO();
    }

    public String[] getPsicologos() {
        return psicologos.getPsicologos();
    }

    public String mostraPsicologos(int opcao){
        switch (opcao) {
            case 0:
                return "Conectando-se com Dr. Laura Cardoso";
            case 1:
                return "Conectando-se com Dr. Rafael Mendes";
            case 2:
                return"Conectando-se com Dr. Mariana Ribeiro";
            case 3:
                return "Conectando-se com Dr. Gustavo Almeida";
            default:
                return "Escolha incorreta";
        }
    }
}
