package com.sgcp.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sgcp.Model.Empleado;

public class OperacionesBD {

    //private Empleado model;
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

    public void SaveNewEmpleado(Empleado E) {
        String query = "INSERT INTO EMPLEADO(ID_EMPLEADO, NOMBRES, APELLIDOS, DIRECCION, TELEF, DNI, PUESTO, CORREO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String id = Integer.toString(E.getID());
        if (!existsEmpleado(id))
            executeUpdateQuery(query, Integer.toString(E.getID()), E.getNombres(), E.getApellidos(), E.getDireccion(), E.getTelefono(), Integer.toString(E.getDNI()), E.getPuesto(), E.getCorreo());
        else
            System.out.println("Error al guardar. Ya existe un registro con el ID");
    }
    
    public void UpdateEmpleado(Empleado E) {
        String query = "UPDATE EMPLEADO SET ID_EMPLEADO = ?, NOMBRES = ?, APELLIDOS = ?, DIRECCION = ?, TELEF = ?, DNI = ?, PUESTO = ?, CORREO = ? WHERE ID_EMPLEADO = ?";
        String id = Integer.toString(E.getID());
        if (!existsEmpleado(id))
            executeUpdateQuery(query, Integer.toString(E.getID()), E.getNombres(), E.getApellidos(), E.getDireccion(), E.getTelefono(), Integer.toString(E.getDNI()), E.getPuesto(), E.getCorreo(), Integer.toString(E.getID()));
        else
            System.out.println("Error al actualizar. Ya existe un registro con el ID");
    }

    public void DeleteEmpleado(String id) {
        String query = "DELETE FROM EMPLEADO WHERE ID_EMPLEADO = ?";
        executeUpdateQuery(query, id);
    }

    public void executeUpdateQuery(String query, Object... params) {
        try (PreparedStatement ps = bd.prepareStatement(query)) {
            // Set parameters
            for (int i = 0; i < params.length; i++) {
                Object param = params[i];
                if (param instanceof String) {
                    ps.setString(i + 1, (String) param);
                } else if (param instanceof Long) {
                    ps.setLong(i + 1, (Long) param);
                } 
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public boolean existsEmpleado(String id) {
        String query = "SELECT COUNT(*) FROM EMPLEADO WHERE ID_EMPLEADO = ?";

        try (PreparedStatement ps = bd.prepareStatement(query)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
        }
        return false;
    }
    
}
