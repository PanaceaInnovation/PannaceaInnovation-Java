package br.com.fiap.main;

import javax.swing.JOptionPane;

// imports
import br.com.fiap.bean.Cadastro;
import br.com.fiap.bean.Login;

public class Helena {
    public static void main(String[] args) {
        // Atributos
        String nome, apelido, cpf, email, senha;
        int matricula;
        String[] escolhas = {"Cadastro", "Login", "Sair"};
        Boolean autoridade ,continua = true;
         
        while(continua == true){
            try {
                //Não se esquecer do break
                int opcao = JOptionPane.showOptionDialog(null, "Bem vindo a Helena, escolha uma opção para continuar","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);

                switch (opcao) {
                    case 0:
                        System.out.println("Cadastro");
                        // não esquecer de instanciar e armazenar isso usando o setter
                        break;
                    case 1:
                        System.out.println("login");
                        // usar o getter para pegar as infos armazenadas
                        break;
                    case 2:
                        System.out.println("Sair");
                        continua = false; // Se tirar isso entra em loop
                        break; // sem isso aparece escolha incorreta
                    default:
                        throw new Exception("Escolha incorreta");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }      
        JOptionPane.showMessageDialog(null, "Fim de programa. Volte sempre!");
    }
    
}
