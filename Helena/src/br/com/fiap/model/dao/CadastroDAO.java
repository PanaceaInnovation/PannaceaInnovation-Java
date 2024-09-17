package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.model.dto.Cadastro;

public class CadastroDAO {
    private Connection con;
    private Cadastro cadastro;

    public CadastroDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    // Metodo
    public String inserir(Cadastro cadastro) {
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
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
