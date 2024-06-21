package br.com.fiap.main;

import javax.swing.JOptionPane;

// imports
import br.com.fiap.bean.Cadastro;
import br.com.fiap.bean.Boletim;
import br.com.fiap.bean.BoletimProfessor;
import br.com.fiap.bean.Login;

public class Helena {
    public static void main(String[] args) {
        // Atributos
        String nome, apelido, cpf, email, senha, lgSenha;
        int matricula, lgMatricula;
        String[] escolhas = {"Cadastro", "Login", "Sair"};
        String[] opcoesLogin = {"Evolução", "Testes", "Revisar", "Ranking", "Psicologia", "Sair"};
        boolean autoridade,continua = true;

        Cadastro cd = new Cadastro();
        Login lg = new Login();
        Boletim bl = new Boletim();
        BoletimProfessor blp = new BoletimProfessor();
         
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
                                JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
                                if(cd.getAutoridade()){
                                    do {                                    
                                        System.out.println("Hello professor"); // TIRAR DEPOIS DE FINALIZADO
                                        // FAZER CASE DAQUI PARA BAIXO PARA ACESSO DE PROFESSOR.
                                        int opcoes = JOptionPane.showOptionDialog(null, "Bem vindo " + cd.getNome()+ ". Como posso lhe ajudar hoje?","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLogin, opcoesLogin[0]);

                                        switch (opcoes) {
                                            case 0:

                                            System.out.println("Hello");
                                            System.out.println(blp.getMaterias()[1]); // necessario colocar o index
                                            
                                                // Fazer opção de boletim de alunos com base na media de cada um. Pode criar nomes ou usar os nossos e atribuir medias para os alunos. baixa, media e alta

                                            break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN
                                            
                                            case 1:
                                                // Classe de professor que mostra quais alunos necessitam fazer os testes. Pode fazer de modo aleatorio. uns com nenhum, mais ou menos e um com todos

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

                                            case 2:
                                                // classe que mostra ao professor quais as recomendações aos alunos de determinada materia, necessario revisão ou ok.

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

                                            case 3:
                                                // Classe de professor todos no ranking, independente se quis participar ou não. Mas ter uma coisa do lado do nome da pessoa (Particpando do ranking: Não ou Sim)

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

                                            case 4:
                                                // Igualmente para professor, eles tambem precisão de psicologos
                                                // Mostrar opções de psicologos para atendimento via tele medicina, quando clicar no psicologo apresentar na tela "Concetando com o psicolgo ...." 

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
                                        System.out.println("hello aluno"); // TIRAR DEPOIS DE FINALIZADO

                                        // FAZER CASE DAQUI PARA BAIXO PARA ACESSO DE ALUNO.
                                        int opcoes = JOptionPane.showOptionDialog(null, "Bem vindo " + cd.getNome()+ ".Como posso lhe ajudar hoje?","Tela inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLogin, opcoesLogin[0]);

                                        switch (opcoes) {
                                            case 0:
                                                JOptionPane.showMessageDialog(null, bl.mostrarBoletim());
                                                break;
                                            
                                            case 1:
                                                // Testes e dentro da classe testes uma opção para uma classe de testes concluidos

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

                                            case 2:
                                                // Uma classe que mostra materias que aconselhamos o aluno estudar

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

                                            case 3:
                                                // Classe que mostra o ranking da sala, mas antes de mostrar o ranking perguntar sempre se deseja participar. Caso a pessoa não aceite mostrar em tela que o ranking esta desabilitado e voltar ao inicio. caso aperte a opção novamente perguntar se quer particpar e se sim, mostrar o ranking com uma quantidade de pessoas com pontuação baseada no tempo de conclusão da simulação.

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN
                                            
                                            case 4:
                                                // Mostrar opções de psicologos para atendimento via tele medicina, quando clicar no psicologo apresentar na tela "Concetando com o psicolgo ...."

                                                break; // NECESSARIO ESSE BREAK PARA NÃO FINALIZAR O APP E VOLTAR AS OPÇOES INICIAIS DO LOGIN

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

    }
    
}
