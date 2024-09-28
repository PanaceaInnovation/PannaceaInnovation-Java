package br.com.fiap.controller;

import br.com.fiap.model.dto.RankingDTO;

public class RankingController {
    private RankingDTO ranking;

    public RankingController(){
        ranking = new RankingDTO();
    }

    public String getRanking() {
        return ranking.getRankingAlunos();
    }
}
