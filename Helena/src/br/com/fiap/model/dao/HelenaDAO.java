package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.dto.Dados;
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
    public String inserir(Dados cadastro) {
        String sql = "Insert into Cadastro(nome, apelido, cpf, matricula, email, senha, autoridade) values(?,?,?,?,?,?,?)";

        // try-with-resources
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, cadastro.getNome());
            ps.setString(2, cadastro.getApelido());
            ps.setString(3, cadastro.getCpf());
            ps.setInt(4, cadastro.getMatricula());
            ps.setString(5, cadastro.getEmail());
            ps.setString(6, cadastro.getSenha());
            ps.setInt(7, cadastro.getAutoridade());

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
                return "Sucesso";
            }else{
                return "Registro não encontrado!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
