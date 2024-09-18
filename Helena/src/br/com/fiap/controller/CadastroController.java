package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.model.dao.CadastroDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Cadastro;

public class CadastroController {
    public String inserirCadastro(String nome, String apelido, String cpf, int matricula, String email, String senha, int autoridade) throws ClassNotFoundException, SQLException{
        
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Cadastro cadastro = new Cadastro();

        cadastro.setNome(nome);
        cadastro.setApelido(apelido);
        cadastro.setCpf(cpf);
        cadastro.setMatricula(matricula);
        cadastro.setEmail(email);
        cadastro.setSenha(senha);
        cadastro.setAutoridade(autoridade);

        CadastroDAO cadastroDAO = new CadastroDAO(con);
        resultado = cadastroDAO.inserir(cadastro);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
