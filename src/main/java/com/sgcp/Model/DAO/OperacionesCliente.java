package com.sgcp.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sgcp.Model.Cliente;

public class OperacionesCliente {

    private Connection bd;
    private OperacionesBD op;

    public OperacionesCliente(Connection bd) {
        this.bd = bd;
    }

    public ArrayList<Cliente> getAllClientes() {
        String Query = "SELECT * FROM CLIENTE";
        ArrayList<Cliente> tabla = new ArrayList<>();

        try {
            Statement st = (Statement) bd.createStatement();          
            ResultSet rs = st.executeQuery(Query);

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("ID_CLIENTE"));
                cliente.setNombres(rs.getString("NOMBRES"));
                cliente.setApellidos(rs.getString("APELLIDOS"));
                cliente.setDireccion(rs.getString("DIRECCION"));
                cliente.setTelefono(rs.getString("TELEF"));
                cliente.setDNI(rs.getInt("DNI"));
                tabla.add(cliente);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Imposible recuperar los datos");
        }
        return tabla;
    }

    public void SaveNewCliente(Cliente E) {
        String query = "INSERT INTO CLIENTE(ID_CLIENTE, NOMBRES, APELLIDOS, DIRECCION, TELEF, DNI) VALUES (?, ?, ?, ?, ?, ?)";
        String id = Integer.toString(E.getID());
        if (!existsCliente(id))
            op.executeUpdateQuery(query, Integer.toString(E.getID()), E.getNombres(), E.getApellidos(), E.getDireccion(), E.getTelefono(), Integer.toString(E.getDNI()));
        else
            System.out.println("Error al guardar. Ya existe un registro con el ID");
    }
    
    public void UpdateCliente(Cliente E) {
        String query = "UPDATE CLIENTE SET ID_CLIENTE = ?, NOMBRES = ?, APELLIDOS = ?, DIRECCION = ?, TELEF = ?, DNI = ?, PUESTO = ?, CORREO = ? WHERE ID_CLIENTE = ?";
        String id = Integer.toString(E.getID());
        if (!existsCliente(id))
            op.executeUpdateQuery(query, Integer.toString(E.getID()), E.getNombres(), E.getApellidos(), E.getDireccion(), E.getTelefono(), Integer.toString(E.getDNI()), Integer.toString(E.getID()));
        else
            System.out.println("Error al actualizar. Ya existe un registro con el ID");
    }

    public void DeleteCliente(String id) {
        String query = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
        op.executeUpdateQuery(query, id);
    }

    public boolean existsCliente(String id) {
        String query = "SELECT COUNT(*) FROM CLIENTE WHERE ID_CLIENTE = ?";

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
