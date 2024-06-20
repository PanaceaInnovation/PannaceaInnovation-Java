package br.com.fiap.main;

import javax.swing.JOptionPane;

// imports
import br.com.fiap.bean.Cadastro;
import br.com.fiap.bean.Login;

public class Helena {
    public static void main(String[] args) {
        // Atributos
        String nome, apelido, cpf, email, senha, lgSenha;
        int matricula, lgMatricula;
        String[] escolhas = {"Cadastro", "Login", "Sair"};
        boolean autoridade,continua = true;
        Cadastro cd = new Cadastro();
        Login lg = new Login();
         
        while(continua){
            try {
                //Não se esquecer do break
                int opcao = JOptionPane.showOptionDialog(null, "Bem vindo a Helena, escolha uma opção para continuar","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);

                switch (opcao) {
                    case 0: // CADASTRO
                        System.out.println("Cadastro");
                        nome = JOptionPane.showInputDialog("Digite seu nome completo:");
                        cd.setNome(nome);

                        apelido = JOptionPane.showInputDialog("Como gostaria de ser chamado: ");
                        cd.setApelido(apelido);

                        do{
                            cpf = JOptionPane.showInputDialog("Digite seu CPF:");
                            if (cd.validaCPF(cpf)) {
                                cd.setCpf(cpf);
                                break;
                            }else {
                                JOptionPane.showMessageDialog(null, "CPF INVÁLIDO: " + cpf);
                            }
                        } while (true);

                        do{
                            matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula da instituição de ensino: "));
                            if(cd.validaMatricula(matricula)){
                                cd.setMatricula(matricula);
                                break;
                            }else{
                                JOptionPane.showMessageDialog(null, "MATRÍCULA INVÁLIDA!");
                            }
                        }while(true);                        

                        email = JOptionPane.showInputDialog("Digite seu email: ");
                        cd.setEmail(email);

                        do{
                            senha = JOptionPane.showInputDialog("Crie uma senha para acesso: ");
                            if(cd.validaSenha(senha)){
                                cd.setSenha(senha);
                                break;
                            }else{
                                JOptionPane.showMessageDialog(null, "SENHA DEVE SER MAIOR QUE 7 CARACTERES !");
                            }
                        }while(true);  

                        autoridade = cd.validaAutoridade(matricula);
                        cd.setAutoridade(autoridade);

                        JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO");
                        break;
                    case 1: // LOGIN
                        System.out.println("login");

                        do {
                            lg.setVerificaMatricula(cd.getMatricula());
                            lg.setVerificaSenha(cd.getSenha());

                            lgMatricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula: "));

                            lgSenha = JOptionPane.showInputDialog("Digite sua senha:");

                            if(lg.validaLogin(lgMatricula, lgSenha)){
                                System.out.println("Professor");
                                break;
                            }else{
                                System.out.println("Aluno");
                                break;
                            }               
                        }while(true);
                        
                        JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
                        break;
                    case 2:
                            JOptionPane.showMessageDialog(null, "Saindo do aplicativo....");
                        continua = false; // Se tirar isso entra em loop
                        break; // sem isso aparece escolha incorreta
                    default:
                        throw new Exception("Escolha incorreta");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }      
        JOptionPane.showMessageDialog(null, "Tchau Tchau " + cd.getNome() + ", bons estudos !"+ "\nAss: Helena"); // VER SE É NECESSARIO TIRAR O CD.GETNOME()

    }
    
}
