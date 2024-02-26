package com.sgcp.Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import com.sgcp.Model.Empleado;

public class OperacionesBD {

    private Empleado model;
    private Connection bd;

    public OperacionesBD(Connection bd) {
        this.bd = bd;
    }

    public ArrayList<String[]> getAllEmpleados() {
        
        String Query = "SELECT * FROM EMPLEADO";
        ArrayList<String[]> tabla = new ArrayList<>();

        try {
            Statement st = (Statement) bd.createStatement();          
            ResultSet rs = st.executeQuery(Query);
            ResultSetMetaData m = rs.getMetaData();
            int n = m.getColumnCount();
            String[] s = new String[n];

            for (int i = 0; i < n; i++)
                s[i] = m.getColumnName(i+1);
            tabla.add(s);

            while (rs.next()) {
                for (int i = 0; i < s.length; i++)
                    s[i] = rs.getString(i);
                tabla.add(s);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Imposible recuperar los datos");
        }

        return tabla;

    }
    
}
