package com.sgcp.Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sgcp.Model.Cita;
import com.sgcp.Model.Inventario;

public class OperacionesInventario {

    private Connection bd;

    public OperacionesInventario(Connection bd) {
        this.bd = bd;
    }

    public ArrayList<Inventario> getAllInventario() {

        String Query = "SELECT * FROM INVENTARIO";
        ArrayList<Inventario> tabla = new ArrayList<>();
        
        try {
            Statement st = (Statement) bd.createStatement();          
            ResultSet rs = st.executeQuery(Query);

            while (rs.next()) {
                int id = rs.getInt("ID_INVENTARIO");
                String nombre = rs.getString("NOMBRE_PRODUCTO");
                String precioCompra = rs.getString("PRECIO_COMPRA");
                String precioVenta = rs.getString("PRECIO_VENTA");
                String stock = rs.getString("STOCK");
                String idProveedor = rs.getString("ID_PROVEEDOR");
                String idEmpleado = rs.getString("ID_EMPLEADO");
                String descripcion = rs.getString("DESCRIPCION");
            
                Inventario inv = new Inventario(id, nombre, precioCompra, precioVenta, stock, idProveedor, idEmpleado, descripcion);
                tabla.add(inv);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Imposible recuperar los datos");
        }
        return tabla;
    }
}
