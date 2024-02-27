package com.sgcp.Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sgcp.Model.Cita;

public class OperacionesCita {
    private Connection bd;

    public OperacionesCita(Connection bd) {
        this.bd = bd;
    }

    public ArrayList<Cita> getAllCitas() {

        String Query = "SELECT * FROM CITA";
        ArrayList<Cita> tabla = new ArrayList<>();
        
        try {
            Statement st = (Statement) bd.createStatement();          
            ResultSet rs = st.executeQuery(Query);

            while (rs.next()) {
                Cita cita = new Cita(rs.getInt("ID_CITA"),rs.getInt("ID_CLIENTE"),rs.getString("FECHA"),rs.getInt("ID_EMPLEADO"));
                tabla.add(cita);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Imposible recuperar los datos");
        }
        return tabla;
    }

    public void SaveNewCita(Cita E) {
        String query = "INSERT INTO CITA(ID_CITA, ID_CLIENTE, ID_EMPLEADO, FECHA) VALUES (?, ?, ?, ?)";
        String id = Integer.toString(E.getID());
        if (!OperacionesGeneral.existsEntity(id, query, "ID_CITA"))
            OperacionesGeneral.executeUpdateQuery(query, id, Integer.toString(E.getId_cliente()), Integer.toString(E.getId_empleado()), E.getFecha());
        else
            System.out.println("Error al guardar. Ya existe un registro con el ID");
    }
    
    public void UpdateCita(Cita E) {
        String query = "UPDATE CITA SET ID_CITA = ?, ID_CLIENTE = ?, ID_EMPLEADO = ?, FECHA = ? WHERE ID_CITA = ?";
        String id = Integer.toString(E.getID());
        if (!OperacionesGeneral.existsEntity(id, query, "ID_CITA"))
            OperacionesGeneral.executeUpdateQuery(query, id, Integer.toString(E.getId_cliente()), Integer.toString(E.getId_empleado()), E.getFecha(), id);
        else
            System.out.println("Error al actualizar. Ya existe un registro con el ID");
    }

    public void DeleteEmpleado(String id) {
        String query = "DELETE FROM CITA WHERE ID_CITA = ?";
        OperacionesGeneral.executeUpdateQuery(query, id);
    }

}

