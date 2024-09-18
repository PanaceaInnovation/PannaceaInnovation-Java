package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.dto.Cadastro;

public class LoginDAO {
    // DAO -> Login -> Controller -> View
    private Connection con;
    Cadastro cadastro;
    
    public LoginDAO(Connection con){
        this.con = con;
    }
    public Connection getCon(){
        return con;
    }

    /**/

    public String consultaLogin(){
        String sql = "select * from Cadastro where matricula = ?"; 
        try (PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1, cadastro.getMatricula() );
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return "Login: ";
            }else{
                return "Registro não encontrado!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
