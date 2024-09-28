package br.com.fiap.view;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.util.ArrayList;

import br.com.fiap.controller.BoletimController;
import br.com.fiap.controller.BoletimProfessorController;
import br.com.fiap.controller.HelenaController;
import br.com.fiap.controller.PsicologiaController;
import br.com.fiap.controller.RankingController;
import br.com.fiap.controller.RevisarController;
import br.com.fiap.controller.RevisarProfessorController;
import br.com.fiap.controller.TesteController;
import br.com.fiap.controller.TestesProfessorController;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.UsuarioDTO;


public class Helena {
    public static void main(String[] args) {
        //Conexão
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioDTO cd = new UsuarioDTO();

        // Atributos
        String nome, apelido, cpf, email, senha;
        int matricula, autoridade;
        String[] escolhas = {"Cadastro", "Login", "Sair"};
        String[] opcoesLogin = {"Boletim", "Testes", "Revisões", "Ranking", "Psicologia", "Conta", "Sair"};
        String[] opcoesLoginProfessor = {"Média alunos", "Testes Alunos", "Revisões", "Ranking Alunos", "Psicologia", "Administrar Alunos","Sair"};
        boolean continua= true;
        boolean loginSucesso = false;

        // CONTROLLER
        HelenaController helenaController = new HelenaController();
        BoletimController boletimController = new BoletimController();
        BoletimProfessorController boletimProfessorController = new BoletimProfessorController();
        TesteController testeController = new TesteController();
        TestesProfessorController testesProfessorController = new TestesProfessorController();
        RevisarController revisarController = new RevisarController();
        RevisarProfessorController revisarProfessorController = new RevisarProfessorController();
        RankingController rankingController = new RankingController();
        PsicologiaController psicologiaController = new PsicologiaController();
         
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
                                matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula da instituição de ensino:\n" + "OBS: Apenas números"));
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
                                senha = JOptionPane.showInputDialog("Crie uma senha para acesso:");
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
                                matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite sua matrícula:\nOBS: Digite 0 para voltar a tela inicial!"));
                                if (matricula == 0) {
                                    break;
                                } else {
                                    senha = JOptionPane.showInputDialog("Digite sua senha:");
                                    String resultado = helenaController.validarUsuario(matricula, senha);
                                    if (resultado.startsWith("Sucesso:")){

                                        nome = resultado.split(":")[1];
                                        JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
    
                                        boolean loginContinua = true;
    
                                        while(loginContinua){
                                            int opcoes = JOptionPane.showOptionDialog(null, "Bem vindo " + nome + ". Como posso lhe ajudar hoje?", "Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLogin, opcoesLogin[0]);
    
                                            switch (opcoes) {
                                                case 0: // Boletim
                                                    String[] materias = boletimController.getMaterias();
                                                    int materiaEscolhida = JOptionPane.showOptionDialog(null, "Escolha uma matéria:", "Boletim", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, materias, materias[0]);
    
                                                    String boletim = boletimController.mostrarBoletim(materiaEscolhida);
                                                    JOptionPane.showMessageDialog(null, boletim);
                                                    break;
                                                case 1: // Testes
                                                    String [] testes = testeController.getTestes();
                                                    int testeEscolhido = JOptionPane.showOptionDialog(null, "Escolha um teste:", "Testes", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, testes, testes[0]);

                                                    String teste = testeController.mostrarTestes(testeEscolhido);
                                                    JOptionPane.showMessageDialog(null, teste);
                                                    break;
                                                case 2: // Revisões
                                                    String[] revisoes = revisarController.getRevisar();
                                                    int revisaoEscolhido =  JOptionPane.showOptionDialog(null, "Escolha uma revisão para verificar seu status:", "Revisões", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, revisoes, revisoes[0]);

                                                    String revisar = revisarController.mostrarRevisao(revisaoEscolhido);
                                                    JOptionPane.showMessageDialog(null, revisar);

                                                    break;
                                                case 3: // Ranking
                                                    String ranking = rankingController.getRanking();
                                                    JOptionPane.showMessageDialog(null, ranking);
                                                    break;
                                                case 4: // Psicologia
                                                    String[] psicologos = psicologiaController.getPsicologos();
                                                    int psicologoEscolhido =  JOptionPane.showOptionDialog(null, "Escolha psicologo para iniciar seu atendimento:", "Psicologia", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, psicologos, psicologos[0]);

                                                    String atendimento = psicologiaController.mostraPsicologos(psicologoEscolhido);
                                                    JOptionPane.showMessageDialog(null, atendimento);
                                                    break;
                                                case 5: 
                                                    UsuarioDTO usuario = helenaController.consultarDadosUsuario(matricula);
                                                    apelido = usuario.getApelido();
                                                    email = usuario.getEmail();
                                                
                                                    String apelidoAtual = JOptionPane.showInputDialog(null, "Digite seu novo apelido ou deixe em branco para manter: ", apelido);
                                                    String emailAtual = JOptionPane.showInputDialog(null, "Digite seu novo email ou deixe em branco para manter: ", email);
                                                    String novaSenha = JOptionPane.showInputDialog(null, "Digite sua nova senha ou deixe em branco para manter:");
                                                
                                                    String apelidoFinal = apelidoAtual.isEmpty() ? apelido : apelidoAtual;
                                                    String emailFinal = emailAtual.isEmpty() ? email : emailAtual;
                                                    String senhaFinal = novaSenha.isEmpty() ? senha : novaSenha;
                                                
                                                    String resultadoAtualizacao = helenaController.atualizarUsuario(matricula, apelidoFinal, emailFinal, senhaFinal);
                                                    JOptionPane.showMessageDialog(null, resultadoAtualizacao);
                                                    break;
                                                case 6: // Volta ao inicio
                                                    JOptionPane.showMessageDialog(null, "Fazendo logout....");
                                                    loginContinua = false;
                                                    break;
                                                default:
                                                    throw new Exception("Escolha incorreta");
                                            }
                                        }
                                        loginSucesso = true;
                                    }else if (resultado.startsWith("Autoridade:")) {
                                        nome = resultado.split(":")[1];
                                        JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
    
                                        boolean loginContinua = true;

                                        while (loginContinua) {
                                            int opcoes = JOptionPane.showOptionDialog(null, "Bem vindo Professor(a) " + nome + ". Como posso lhe ajudar hoje?", "Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLoginProfessor, opcoesLoginProfessor[0]);

                                            switch (opcoes) {
                                                case 0: //media
                                                    String[] materias = boletimProfessorController.getMaterias();
                                                    int materiaEscolhida = JOptionPane.showOptionDialog(null, "Escolha uma matéria:", "Boletim", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, materias, materias[0]);

                                                    String medias = boletimProfessorController.mostrarBoletimProfessor(materiaEscolhida);
                                                    JOptionPane.showMessageDialog(null, medias);
                                                    break;
                                                case 1: // Testes
                                                    String[] testes = testesProfessorController.getTestes();
                                                    int testeEscolhido = JOptionPane.showOptionDialog(null, "Escolha teste para verificar os status:", "Testes", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, testes, testes[0]);

                                                    String testesAlunos = testesProfessorController.mostrarTestesProfessor(testeEscolhido);
                                                    JOptionPane.showMessageDialog(null, testesAlunos);
                                                    break;
                                                case 2: // Revisões
                                                    String[] revisoes = revisarProfessorController.getTestes();
                                                    int revisaoEscolhida = JOptionPane.showOptionDialog(null, "Escolha uma materia para verificar os status de revisão:", "Revisões", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, revisoes, revisoes[0]);

                                                    String revisoesAlunos = revisarProfessorController.mostrarRevisoesProfessor(revisaoEscolhida);
                                                    JOptionPane.showMessageDialog(null, revisoesAlunos);
                                                    break;
                                                case 3: // Ranking
                                                    String ranking = rankingController.getRanking();
                                                    JOptionPane.showMessageDialog(null, ranking);
                                                    break;
                                                case 4: // Psicologia
                                                    String[] psicologos = psicologiaController.getPsicologos();
                                                    int psicologoEscolhido =  JOptionPane.showOptionDialog(null, "Escolha psicologo para iniciar seu atendimento:", "Psicologia", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, psicologos, psicologos[0]);

                                                    String atendimento = psicologiaController.mostraPsicologos(psicologoEscolhido);
                                                    JOptionPane.showMessageDialog(null, atendimento);
                                                    break;
                                                case 5: // Administrar alunos
                                                    try {
                                                        ArrayList<UsuarioDTO> alunos = helenaController.listarAlunos();
                                                        if (alunos.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.");
                                                        } else {
                                                            String[] opcoesAlunos = new String[alunos.size() + 1];
                                                            for (int i = 0; i < alunos.size(); i++) {
                                                                opcoesAlunos[i] = alunos.get(i).getNome() + " - Matrícula: " + alunos.get(i).getMatricula();
                                                            }
                                                            opcoesAlunos[alunos.size()] = "Apenas visualizar alunos";

                                                            int escolha = JOptionPane.showOptionDialog(null, "Escolha um aluno para excluir ou apenas visualizar:", "Administrar Alunos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesAlunos, opcoesAlunos[0]);
                                                            
                                                            if (escolha != -1 && escolha != alunos.size()) { // Se a opção não for "Apenas visualizar"
                                                                int matriculaAluno = alunos.get(escolha).getMatricula();
                                                                int confirmacao = JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o aluno " + alunos.get(escolha).getNome() + "?");

                                                                if (confirmacao == JOptionPane.YES_OPTION) {
                                                                    String resultadoExclusao = helenaController.excluirAluno(matriculaAluno);
                                                                    JOptionPane.showMessageDialog(null, resultadoExclusao);
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "Nenhum aluno foi excluído.");
                                                                }
                                                            } else {
                                                                // O professor optou por apenas visualizar os alunos
                                                                StringBuilder listaAlunos = new StringBuilder("Alunos da sala:\n");
                                                                for (UsuarioDTO aluno : alunos) {
                                                                    listaAlunos.append(aluno.getNome()).append(" - Matrícula: ").append(aluno.getMatricula()).append("\n");
                                                                }
                                                                JOptionPane.showMessageDialog(null, listaAlunos.toString());
                                                            }
                                                        }
                                                    } catch (Exception e) {
                                                        JOptionPane.showMessageDialog(null, "Erro ao administrar alunos: " + e.getMessage());
                                                    }
                                                    break;
                                                case 6:
                                                    JOptionPane.showMessageDialog(null, "Fazendo logout....");
                                                    loginContinua = false;
                                                    break;
                                            
                                                default:
                                                    throw new Exception("Escolha incorreta");
                                            }
                                        }
                                        loginSucesso = true;
                                    }else {
                                        JOptionPane.showMessageDialog(null, "CREDENCIAIS INVÁLIDAS!" + "\nTente novamente.");
                                    }
                                }
                            } while (!loginSucesso);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                        }
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Saindo do aplicativo....");
                        continua = false;
                        break;
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
