package com.sgcp.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Autenticacion {

    private Connection bd;

    public Autenticacion(Connection bd) {
        this.bd = bd;
    }

    public Boolean checkUser(String user, String password) {

        Boolean check = false;
        String Query = "SELECT COUNT(*) FROM EMPLEADO WHERE CORREO = ? AND DNI = ?";
        
        try (PreparedStatement ps = bd.prepareStatement(Query)){
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet result = ps.executeQuery();

            if (result.next()){
                int count = result.getInt(1);
                check = count > 0;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
        
    }
    
}
