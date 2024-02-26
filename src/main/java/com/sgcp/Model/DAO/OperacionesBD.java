package com.sgcp.Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sgcp.Model.Empleado;

public class OperacionesBD {

    private Empleado model;
    private Connection bd;

    public OperacionesBD(Connection bd) {
        this.bd = bd;
    }


    public ArrayList<Empleado> getAllEmpleados() {

        String Query = "SELECT * FROM EMPLEADO";
        ArrayList<Empleado> tabla = new ArrayList<>();
        
        try {
            Statement st = (Statement) bd.createStatement();          
            ResultSet rs = st.executeQuery(Query);

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setID(rs.getInt("ID_EMPLEADO"));
                empleado.setNombres(rs.getString("NOMBRES"));
                empleado.setApellidos(rs.getString("APELLIDOS"));
                empleado.setDireccion(rs.getString("DIRECCION"));
                empleado.setTelefono(rs.getString("TELEF"));
                empleado.setDNI(rs.getInt("DNI"));
                empleado.setPuesto(rs.getString("PUESTO"));
                empleado.setCorreo(rs.getString("CORREO"));
                tabla.add(empleado);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Imposible recuperar los datos");
        }
        return tabla;
    }
    
}
