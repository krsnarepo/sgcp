package com.sgcp.Controller;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.sgcp.Model.Resultado;
import com.sgcp.Model.DAO.OperacionesResultado;
import com.sgcp.View.GUIResultados;

public class ControladorResultados {
    private GUIResultados view;
    private OperacionesResultado BD;

    public ControladorResultados(GUIResultados m, Connection bd) {
        BD = new OperacionesResultado(bd);
        view = m;
        //view.setButton2ActionListener(new ButtonAdd());
        UpdateTable();
    }

    private void UpdateTable() {
        view.Table1SetModel(UpdateResultadoTable());
    }

    private DefaultTableModel UpdateResultadoTable() {

        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Resultado> resultados = BD.getAllResultado();

        model.addColumn("ID_RESULTADO");
        model.addColumn("ID_CITA");
        model.addColumn("RESULTADO");

        for (Resultado e : resultados) {
            model.addRow(new Object[]{
                e.getId_resultado(),
                e.getId_cita(),
                e.getResult()
            });
        }

        return model;

    }
}
