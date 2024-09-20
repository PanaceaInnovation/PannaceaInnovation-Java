package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.model.dto.UsuarioDTO;

public class LoginDAO {
    // DAO -> Login -> Controller -> View
    private Connection con;
    UsuarioDTO cadastro;
    
    public LoginDAO(Connection con){
        this.con = con;
    }
    public Connection getCon(){
        return con;
    }
}
