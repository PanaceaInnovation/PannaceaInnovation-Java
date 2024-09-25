package br.com.fiap.view;

import java.sql.Connection;
import javax.swing.JOptionPane;

import br.com.fiap.controller.BoletimController;
import br.com.fiap.controller.HelenaController;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.BoletimProfessor;
import br.com.fiap.model.dto.UsuarioDTO;
import br.com.fiap.model.dto.LoginDTO;
import br.com.fiap.model.dto.Psicologia;
import br.com.fiap.model.dto.Ranking;
import br.com.fiap.model.dto.Revisar;
import br.com.fiap.model.dto.RevisarProfessor;
import br.com.fiap.model.dto.Teste;
import br.com.fiap.model.dto.TestesProfessor;


public class Helena {
    public static void main(String[] args) {
        //Conexão
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioDTO cd = new UsuarioDTO();
        HelenaController helenaController = new HelenaController();

        // Atributos
        String nome, apelido, cpf, email, senha, lgSenha;
        int matricula, autoridade,lgMatricula;
        String[] escolhas = {"Cadastro", "Login", "Sair"};
        String[] opcoesLogin = {"Boletim", "Testes", "Revisar", "Ranking", "Psicologia", "Sair"};
        boolean continua= true;
        boolean loginSucesso = false;

        
        LoginDTO lg = new LoginDTO();
        BoletimProfessor blp = new BoletimProfessor();
        BoletimController boletimController = new BoletimController(); // Adiciona o controller do boletim
        Teste ts = new Teste();
        TestesProfessor tsp = new TestesProfessor();
        Revisar rv = new Revisar();
        RevisarProfessor rp = new RevisarProfessor();
        Ranking rk = new Ranking();
        Psicologia ps = new Psicologia();
         
        while(continua){
            try {
                //Não se esquecer do break
                int opcao = JOptionPane.showOptionDialog(null, "Bem vindo a Helena, escolha uma opção para continuar","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, escolhas, escolhas[0]);

                switch (opcao) {
                    case 0: // CADASTRO
                        try {
                            // Solicitar o nome
                            nome = JOptionPane.showInputDialog("Digite seu nome completo:");
                            cd.setNome(nome);

                            // Solicitar o apelido
                            apelido = JOptionPane.showInputDialog("Como gostaria de ser chamado: ");
                            cd.setApelido(apelido);

                            // Validação de CPF
                            do {
                                cpf = JOptionPane.showInputDialog("Digite seu CPF:");
                                if (cd.validaCPF(cpf)) {
                                    cd.setCpf(cpf);
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "CPF INVÁLIDO: " + cpf);
                                }
                            } while (true);

                            // Validação de matrícula
                            do {
                                matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula da instituição de ensino: "));
                                if (cd.validaMatricula(matricula)) {
                                    cd.setMatricula(matricula);
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "MATRÍCULA INVÁLIDA!");
                                }
                            } while (true);

                            // Solicitar o email
                            email = JOptionPane.showInputDialog("Digite seu email: ");
                            cd.setEmail(email);

                            // Validação de senha
                            do {
                                senha = JOptionPane.showInputDialog("Crie uma senha para acesso: ");
                                if (cd.validaSenha(senha)) {
                                    cd.setSenha(senha);
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "SENHA DEVE SER MAIOR QUE 7 CARACTERES!");
                                }
                            } while (true);

                            // Definir autoridade
                            autoridade = cd.validaAutoridade(matricula) ? 1 : 0;
                            cd.setAutoridade(autoridade);

                            // Chamar o controller para inserir o cadastro
                            String resultado = helenaController.inserirUsuario(nome, apelido, cpf, matricula, email, senha, autoridade);
                            
                            // Verifica o resultado da inserção
                            if (resultado.equals("Inserido com sucesso!")) {
                                JOptionPane.showMessageDialog(null, resultado); // Exibe a mensagem de sucesso
                            } else {
                                JOptionPane.showMessageDialog(null, resultado); // Exibe a mensagem de erro (como "Usuário já cadastrado")
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro: " + e.getMessage());
                        }
                        break;
                    case 1: // LOGIN
                        try {
                            do {
                                matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula:"));
                                senha = JOptionPane.showInputDialog("Digite sua senha:");
                            
                                // Envia os dados para o controller
                                String resultado = helenaController.validarUsuario(matricula, senha);

                                if (resultado.startsWith("Sucesso:")){

                                    nome = resultado.split(":")[1];
                                    JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");

                                    boolean loginContinua = true;

                                    while(loginContinua){
                                        int opcoes = JOptionPane.showOptionDialog(null, "Bem vindo " + nome + ". Como posso lhe ajudar hoje?", "Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLogin, opcoesLogin[0]);

                                        switch (opcoes) {
                                            case 0: // Boletim
                                                String[] materias = boletimController.getMaterias(); // Método para obter as matérias
                                                int materiaEscolhida = JOptionPane.showOptionDialog(null, "Escolha uma matéria:", "Boletim", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, materias, materias[0]);

                                                String boletim = boletimController.mostrarBoletim(materiaEscolhida);
                                                JOptionPane.showMessageDialog(null, boletim);
                                                break;
                                            case 5:
                                                JOptionPane.showMessageDialog(null, "Saindo do aplicativo....");
                                                loginContinua = false;
                                                continua = false; // Termina o loop principal
                                                break;
                                        
                                            default:
                                                throw new Exception("Escolha incorreta");
                                        }
                                    }
                                    loginSucesso = true;
                                }else if (resultado.equals("Autoridade")) {
                                    JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO - USUÁRIO AUTORIDADE");
                                    loginSucesso = true;
                                    // Ações para usuário com autoridade
                                    break;
                                }else {
                                    JOptionPane.showMessageDialog(null, "CREDENCIAIS INVÁLIDAS!" + "\nTente novamente.");
                                }
                            } while (!loginSucesso);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                        }
                        break;
                        
                        /*
                        System.out.println("login");

                        do {
                            lg.setVerificaMatricula(cd.getMatricula());
                            lg.setVerificaSenha(cd.getSenha());

                            lgMatricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula: "));

                            lgSenha = JOptionPane.showInputDialog("Digite sua senha:");

                            if(lg.validaLogin(lgMatricula, lgSenha)){
                                JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
                                if(cd.getAutoridade() == 1){
                                    do {                                    
                                        int opcoes = JOptionPane.showOptionDialog(null, "Bem vindo " + cd.getNome()+ ". Como posso lhe ajudar hoje?","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLogin, opcoesLogin[0]);

                                        switch (opcoes) {
                                            case 0:
                                                int opcaoPF = JOptionPane.showOptionDialog(null, "Quais notas gostaria de ver:","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, blp.materias(), blp.materias()[0]);

                                                switch (opcaoPF) {
                                                    case 0:
                                                        String materia1 = ("Média dos alunos em anatomia e Fisiologia Aplicadas à Laparoscopia\n" + "Vitor Hugo: 5.70 - Felipe Arnus: 9.5 - Leticia Resina: 7.7 - João Vieira: 10 - João Chambrone: 7.0");
                                                        JOptionPane.showMessageDialog(null, materia1);
                                                        break;

                                                    case 1:
                                                        String materia2 = ("Média dos alunos em Fundamentos da Cirurgia Laparoscópica\n" + "Vitor Hugo: 8.0 - Felipe Arnus: 6.5 - Leticia Resina: 10 - João Vieira: 4.6 - João Chambrone: 8.5");
                                                        JOptionPane.showMessageDialog(null, materia2);
                                                        break;
                                                    case 2:
                                                        String materia3 = ("Média dos alunos em equipamentos e Instrumentação\n" + "Vitor Hugo: 7.6 - Felipe Arnus: 5.5 - Leticia Resina: 9.8 - João Vieira: 6.5 - João Chambrone: 9.5");
                                                        JOptionPane.showMessageDialog(null, materia3);
                                                        break;
                                                    case 3:
                                                        String materia4 = ("Média dos alunos em técnicas Básicas de Laparoscopia\n" + "Vitor Hugo: 8.0 - Felipe Arnus: 10 - Leticia Resina: 10 - João Vieira: 6.6 - João Chambrone: 9.5");
                                                        JOptionPane.showMessageDialog(null, materia4);
                                                        break;
                                                    default:
                                                        String erro = "5 Escolha incorreta";
                                                        System.out.println(erro);}
                                                break;
                                            
                                            case 1:
                                                int opcaoTSP = JOptionPane.showOptionDialog(null, "Quais testes gostaria de ver:","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tsp.testes(), tsp.testes()[0]);

                                                switch (opcaoTSP) {
                                                    case 0:
                                                        String teste1 = ("Testes dos alunos em Procedimentos Laparoscópicos Comuns\n" + "Vitor Hugo: A1: Concluído - A2: Concluído - A3: Concluído \nFelipe Arnus: A1: Pendente - A2: Pendente - A3: Concluído \nLeticia Resina: A1: Concluído - A2: Pendente - A3: Concluído \nJoão Vieira: A1: Pendente - A2: Pendente - A3: Concluído \nJoão Chambrone: A1: Concluído - A2: Concluído - A3: Pendente");
                                                        JOptionPane.showMessageDialog(null, teste1);
                                                        break;
                                                    case 1:
                                                        String teste2 = ("Testes dos alunos em Complicações e Gestão de Riscos\n" + "Vitor Hugo: A1: Concluído - A2: Concluído - A3: Concluído \nFelipe Arnus: A1: Pendente - A2: Pendente - A3: Concluído \nLeticia Resina: A1: Concluído - A2: Pendente - A3: Concluído \nJoão Vieira: A1: Pendente - A2: Pendente - A3: Concluído \nJoão Chambrone: A1: Concluído - A2: Concluído - A3: Pendente");
                                                        JOptionPane.showMessageDialog(null, teste2);
                                                        break;
                                                    case 2:
                                                        String teste3 = ("Testes dos alunos em Treinamento em Simuladores e Prática em Laboratório\n" + "Vitor Hugo: A1: Concluído - A2: Concluído - A3: Concluído \nFelipe Arnus: A1: Pendente - A2: Pendente - A3: Concluído \nLeticia Resina: A1: Concluído - A2: Pendente - A3: Concluído \nJoão Vieira: A1: Pendente - A2: Pendente - A3: Concluído \nJoão Chambrone: A1: Concluído - A2: Concluído - A3: Pendente");
                                                        JOptionPane.showMessageDialog(null, teste3);
                                                        break;
                                                    default:
                                                        String erro = "Escolha incorreta";
                                                        System.out.println(erro);}
                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

                                            case 2:
                                                int opcaoRevisao = JOptionPane.showOptionDialog(null, "Selecione a opção de revisão que deseja ver:", "Tela de Revisão", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, rp.materias(), rp.materias()[0]);

                                                switch (opcaoRevisao) {
                                                    case 0:
                                                        String revisaoMateria1 = rp.mostrarRevisaoProfessor();
                                                        JOptionPane.showMessageDialog(null, revisaoMateria1);
                                                        break;
                                                
                                                    case 1:
                                                        String revisaoMateria2 = rp.mostrarRevisaoProfessor();
                                                        JOptionPane.showMessageDialog(null, revisaoMateria2);
                                                        break;
                                                
                                                    case 2:
                                                        String revisaoMateria3 = rp.mostrarRevisaoProfessor();
                                                        JOptionPane.showMessageDialog(null, revisaoMateria3);
                                                        break;
                                                
                                                    case 3:
                                                        String revisaoMateria4 = rp.mostrarRevisaoProfessor();
                                                        JOptionPane.showMessageDialog(null, revisaoMateria4);
                                                        break;
                                                
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Escolha incorreta");}

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

                                            case 3:
                                                String rankingAlunos = rk.mostrarRanking();
                                                JOptionPane.showMessageDialog(null, rankingAlunos);

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

                                            case 4:
                                                JOptionPane.showMessageDialog(null, ps.exibePsicologos()); 

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

                                            case 5:
                                                JOptionPane.showMessageDialog(null, "Saindo do aplicativo....");
                                                continua = false; // Se tirar isso entra em loop
                                                break; // sem isso aparece escolha incorreta
                                            default:
                                                throw new Exception("Escolha incorreta");
                                        }
                                    } while (continua);
                                }else{
                                    do { 

                                        int opcoes = JOptionPane.showOptionDialog(null, "Bem vindo " + cd.getNome()+ ".Como posso lhe ajudar hoje?","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLogin, opcoesLogin[0]);

                                        switch (opcoes) {
                                            case 0:
                                                JOptionPane.showMessageDialog(null,boletimController.mostrarBoletim());
                                                break;
                                            case 1:
                                                JOptionPane.showMessageDialog(null, ts.mostrarTestes());
                                                break;
                                            case 2:
                                                JOptionPane.showMessageDialog(null, rv.mostrarRevisao());
                                                break;
                                            case 3:
                                                String rankingAlunos = rk.mostrarRanking();
                                                JOptionPane.showMessageDialog(null, rankingAlunos);
                                                break; 
                                            
                                            case 4:
                                                JOptionPane.showMessageDialog(null, ps.exibePsicologos());
                                                break;

                                            case 5:
                                                JOptionPane.showMessageDialog(null, "Saindo do aplicativo....");
                                                continua = false; // Se tirar isso entra em loop
                                                break; // sem isso aparece escolha incorreta
                                            default:
                                                throw new Exception("Escolha incorreta");
                                        }
                                    } while (continua);
                                }
                                break;
                            }else{
                                JOptionPane.showMessageDialog(null, "CREDENCIAIS INVÁLIDAS!");
                                break;
                            }               
                        }while(true);
                        break;
                    */
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
        JOptionPane.showMessageDialog(null, "Tchau Tchau e bons estudos !"+ "\nAss: Helena");
        ConnectionFactory.fecharConexao(con);
    }
    
}
