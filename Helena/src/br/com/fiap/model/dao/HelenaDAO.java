package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.dto.UsuarioDTO;
import br.com.fiap.model.dto.LoginDTO;

public class HelenaDAO {
    private Connection con;

    public HelenaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }
    

    // Metodo

    //CREATE
    public String inserir(UsuarioDTO usuarioDTO) {
        String sql = "Insert into Cadastro(nome, apelido, cpf, matricula, email, senha, autoridade) values(?,?,?,?,?,?,?)";

        // try-with-resources
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, usuarioDTO.getNome());
            ps.setString(2, usuarioDTO.getApelido());
            ps.setString(3, usuarioDTO.getCpf());
            ps.setInt(4, usuarioDTO.getMatricula());
            ps.setString(5, usuarioDTO.getEmail());
            ps.setString(6, usuarioDTO.getSenha());
            ps.setInt(7, usuarioDTO.getAutoridade());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Falha ao inserir!";
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1) {
                return "Usuario já cadastrado";
            } else {
                return "Erro de SQL: " + e.getMessage();   
            }
        }
    }

    //READ
    public String consultaLogin(LoginDTO loginDTO){
        String sql = "select * from Cadastro where matricula = ? AND senha = ?"; 
        try (PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1, loginDTO.getMatricula() );
            ps.setString(2, loginDTO.getSenha() );
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String nome = rs.getString("nome");
                int autoridade = rs.getInt("autoridade");
                if (autoridade == 1) {
                    return "Autoridade:" + nome;
                } else {
                    return "Sucesso:" + nome;
                }
            }else{
                return "Registro não encontrado!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
