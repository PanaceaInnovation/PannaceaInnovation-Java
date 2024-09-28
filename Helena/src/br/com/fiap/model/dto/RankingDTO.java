package br.com.fiap.model.dto;

public class RankingDTO {
    private String rankingAlunos = "Ranking de conclusão do Treinamento em Simuladores e Prática em Laboratório\n" + "1º Vitor Hugo: 26s \n2º João Chambrone: 28s \n3º Leticia Resina: 29s \n4º Felipe Arnus: 31s \n5º João Vieira: 35s";

    public RankingDTO(){}

    public String getRankingAlunos() {
        return rankingAlunos;
    }
    public void setRankingAlunos(String rankingAlunos) {
        this.rankingAlunos = rankingAlunos;
    }
}
