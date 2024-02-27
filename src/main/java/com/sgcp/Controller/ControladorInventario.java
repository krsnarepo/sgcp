package com.sgcp.Controller;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.sgcp.Model.Inventario;
import com.sgcp.Model.DAO.OperacionesInventario;
import com.sgcp.View.GUIInventario;
import com.sgcp.View.GUIInventarioEmergente;

public class ControladorInventario {
    
    private GUIInventario view;
    private OperacionesInventario BD;

    public ControladorInventario(GUIInventario m, Connection bd) {
        BD = new OperacionesInventario(bd);
        view = m;
        //view.setButton2ActionListener(new ButtonAdd());
        UpdateTable();
    }

    private void UpdateTable() {
        view.Table1SetModel(UpdateInventarioTable());
    }

    private DefaultTableModel UpdateInventarioTable() {

        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Inventario> inventarios = BD.getAllInventario();

        model.addColumn("ID_INVENTARIO");
        model.addColumn("NOMBRE_PRODUCTO");
        model.addColumn("PRECIO_COMPRA");
        model.addColumn("PRECIO_VENTA");
        model.addColumn("STOCK");
        model.addColumn("ID_PROVEEDOR");
        model.addColumn("ID_EMPLEADO");
        model.addColumn("DESCRIPCION");

        for (Inventario e : inventarios) {
            model.addRow(new Object[]{
                e.getID(),
                e.getNombre(),
                e.getPrecioCompra(),
                e.getPrecioVenta(),
                e.getStock(),
                e.getIdProveedor(),
                e.getIdEmpleado(),
                e.getDescripcion()
            });
        }

        return model;

    }


}
