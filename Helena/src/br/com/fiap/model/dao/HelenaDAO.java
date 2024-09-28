package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.dto.UsuarioDTO;
import br.com.fiap.model.dto.LoginDTO;

public class HelenaDAO {
    private Connection con;
    private UsuarioDTO usuarioDTO;
    private LoginDTO loginDTO;

    public HelenaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    // Metodo

    //CREATE
    public String inserir(Object object) {
        usuarioDTO = (UsuarioDTO) object;
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

    // Update

    public String atualizarDados(int matricula, String apelido, String email, String senha) {
        String sql = "UPDATE Cadastro SET apelido = ?, email = ?, senha = ? WHERE matricula = ?";
    
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, apelido);
            ps.setString(2, email);
            ps.setString(3, senha);
            ps.setInt(4, matricula);
    
            if (ps.executeUpdate() > 0) {
                return "Dados atualizados com sucesso!";
            } else {
                return "Falha ao atualizar os dados!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    //READ

    public UsuarioDTO consultarDadosUsuario(int matricula) {
        String sql = "SELECT apelido, email FROM Cadastro WHERE matricula = ?";
        UsuarioDTO usuario = new UsuarioDTO();
    
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();
    
            if (rs.next()) {
                usuario.setApelido(rs.getString("apelido"));
                usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public String consultaLogin(Object object){
        loginDTO = (LoginDTO) object;
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

    public ArrayList<UsuarioDTO> listarAlunos() throws SQLException {
        ArrayList<UsuarioDTO> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Cadastro WHERE autoridade = 0"; 
        
        try (PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                UsuarioDTO aluno = new UsuarioDTO();
                aluno.setNome(rs.getString("nome"));
                aluno.setApelido(rs.getString("apelido"));
                aluno.setMatricula(rs.getInt("matricula"));
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    // Delete
    public String excluirAluno(int matricula) throws SQLException {
        String sql = "DELETE FROM Cadastro WHERE matricula = ?";
        
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, matricula);
            if (ps.executeUpdate() > 0) {
                return "Aluno excluído com sucesso!";
            } else {
                return "Falha ao excluir aluno!";
            }
        }
    }

}
