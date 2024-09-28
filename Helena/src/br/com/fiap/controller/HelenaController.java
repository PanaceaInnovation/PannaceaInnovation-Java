package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.HelenaDAO;
import br.com.fiap.model.dto.UsuarioDTO;
import br.com.fiap.model.dto.LoginDTO;

public class HelenaController {
    // DAO -> DTO -> Controller -> View
    public String inserirUsuario(String nome, String apelido, String cpf, int matricula, String email, String senha, int autoridade) throws ClassNotFoundException, SQLException{
        
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioDTO dados = new UsuarioDTO();

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

    public String atualizarUsuario(int matricula, String apelido, String email, String senha) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
    
        HelenaDAO helenaDAO = new HelenaDAO(con);
        resultado = helenaDAO.atualizarDados(matricula, apelido, email, senha);
    
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public UsuarioDTO consultarDadosUsuario(int matricula) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        HelenaDAO helenaDAO = new HelenaDAO(con);
    
        UsuarioDTO usuario = helenaDAO.consultarDadosUsuario(matricula);
        ConnectionFactory.fecharConexao(con);
        return usuario;
    }

    public ArrayList<UsuarioDTO> listarAlunos() throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.abrirConexao();
        HelenaDAO helenaDAO = new HelenaDAO(con);
        ArrayList<UsuarioDTO> alunos = helenaDAO.listarAlunos();
        ConnectionFactory.fecharConexao(con);
        return alunos;
    }

    public String excluirAluno(int matricula) throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.abrirConexao();
        HelenaDAO helenaDAO = new HelenaDAO(con);
        String resultado = helenaDAO.excluirAluno(matricula);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

}
