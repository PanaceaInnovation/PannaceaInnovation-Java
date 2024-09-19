package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.HelenaDAO;
import br.com.fiap.model.dto.Dados;
import br.com.fiap.model.dto.LoginDTO;

public class HelenaController {
    // DAO -> DTO -> Controller -> View
    public String inserirUsuario(String nome, String apelido, String cpf, int matricula, String email, String senha, int autoridade) throws ClassNotFoundException, SQLException{
        
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Dados dados = new Dados();

        dados.setNome(nome);
        dados.setApelido(apelido);
        dados.setCpf(cpf);
        dados.setMatricula(matricula);
        dados.setEmail(email);
        dados.setSenha(senha);
        dados.setAutoridade(autoridade);

        HelenaDAO helenaDAO = new HelenaDAO(con);
        resultado = helenaDAO.inserir(dados);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String validarUsuario(int matricula, String senha){
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setMatricula(matricula);
        loginDTO.setSenha(senha);

        HelenaDAO helenaDAO = new HelenaDAO(con);
        resultado = helenaDAO.consultaLogin(loginDTO);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }


}
