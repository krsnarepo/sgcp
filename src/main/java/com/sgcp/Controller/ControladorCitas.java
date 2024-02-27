package com.sgcp.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.sgcp.Controller.ControladorEmpleados.Guardar;
import com.sgcp.Model.Cita;
import com.sgcp.Model.Empleado;
import com.sgcp.Model.DAO.OperacionesCita;
import com.sgcp.View.GUICitas;
import com.sgcp.View.GUICitasEmergente;
import com.sgcp.View.GUIEmpleadosEmergente;

public class ControladorCitas {

    private Cita model;
    private GUICitas view;
    private OperacionesCita BD;

    public ControladorCitas(GUICitas m, Connection bd) {

        BD = new OperacionesCita(bd);
        view = m;
        view.setButton2ActionListener(null);
        UpdateTable();
    }

    private void UpdateTable() {
        view.Table1SetModel(UpdateEmpleadoTable());
    }

    private DefaultTableModel UpdateEmpleadoTable() {
        
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Cita> citas = BD.getAllCitas();

        model.addColumn("ID_CITA");
        model.addColumn("ID_CLIENTE");
        model.addColumn("ID_EMPLEADO");
        model.addColumn("FECHA");

        for (Cita e : citas) {
            model.addRow(new Object[] {
                e.getID(),
                e.getId_cliente(),
                e.getId_empleado(),
                e.getFecha()
            });
        }

        return model;
    
    }

    public class ButtonAdd implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent arg0) {
            GUICitasEmergente emergente = new GUICitasEmergente();
            //emergente.setButton1ActionListener(new Guardar(emergente,0));
        }
    
    }

    public class Guardar implements ActionListener {

        private GUICitasEmergente addon;
        private int mode;

        public Guardar(GUICitasEmergente panel, int mode) {
            addon = panel;
            this.mode = mode;
        }

        @Override
        public void actionPerformed(ActionEvent event) {

            try {
                model = new Cita(Integer.parseInt(addon.getIdField()), Integer.parseInt(addon.getIdClField()), addon.getDateField(), Integer.parseInt(addon.getIdEmField()));

                if (mode == 0) {
                    BD.SaveNewCita(model);
                } else if (mode == 1) {
                    BD.UpdateCita(model);
                }

                UpdateTable();
                addon.dispose();
            } catch (Exception e) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(addon, "Error al ingresar los datos. Verifique los campos");
            }
            
        }

    }


}
