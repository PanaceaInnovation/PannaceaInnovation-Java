package br.com.fiap.model.dto;

public class BoletimProfessorDTO extends BoletimDTO {
    
    public BoletimProfessorDTO() {}

    public String[] materias(){
        return super.getMaterias();
    }

    public String getMediaAlunos(int opcaoMateria) {
        switch (opcaoMateria) {
            case 0:
                return "Média dos alunos em Anatomia e Fisiologia Aplicadas à Laparoscopia\n" +
                        "Vitor Hugo: 5.70 - Felipe Arnus: 9.5 - Leticia Resina: 7.7 - João Vieira: 10 - João Chambrone: 7.0";
            case 1:
                return "Média dos alunos em Fundamentos da Cirurgia Laparoscópica\n" +
                        "Vitor Hugo: 8.0 - Felipe Arnus: 6.5 - Leticia Resina: 10 - João Vieira: 4.6 - João Chambrone: 8.5";
            case 2:
                return "Média dos alunos em Equipamentos e Instrumentação\n" +
                        "Vitor Hugo: 7.6 - Felipe Arnus: 5.5 - Leticia Resina: 9.8 - João Vieira: 6.5 - João Chambrone: 9.5";
            case 3:
                return "Média dos alunos em Técnicas Básicas de Laparoscopia\n" +
                        "Vitor Hugo: 8.0 - Felipe Arnus: 10 - Leticia Resina: 10 - João Vieira: 6.6 - João Chambrone: 9.5";
            default:
                return "Escolha incorreta";
        }
    }
}
