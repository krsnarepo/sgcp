package com.sgcp.Model.DAO;

import java.sql.Connection;
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
        String Query = "SELECT COUNT(*) FROM EMPLEADO WHERE CORREO = '" + user
                        + "' AND DNI = '" + password + "'";
        
        try {
            Statement statement = (Statement) bd.createStatement();
            ResultSet result = statement.executeQuery(Query);
            ResultSetMetaData metadata = result.getMetaData();
            String name = metadata.getColumnName(1);
            result.next();
            int count = result.getInt(name);
            check = count > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
        
    }
    
}
