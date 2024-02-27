package com.sgcp.Controller;
import com.sgcp.Model.Empleado;
import com.sgcp.Model.DAO.OperacionesBD;
import com.sgcp.View.GUI_Empleados;
import com.sgcp.View.GUI_EmpleadosAdd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.util.ArrayList;

public class ControladorEmpleados {
    
    private JPanel contentPane;
    private GUI_Empleados view;
    private Empleado model;
    private OperacionesBD BD;
    
    public ControladorEmpleados(GUI_Empleados m, JPanel panel, Connection bd) {
        BD = new OperacionesBD(bd);
        contentPane = panel;
        view = m;
        view.Table1SetModel(UpdateEmpleadoTable());
        view.setButton2ActionListener(new ButtonAdd());
        view.setButton3ActionListener(new ButtonUpdate());
        view.setButton4ActionListener(new ButtonDelete());
    }

    private void UpdateTable() {
        view.Table1SetModel(UpdateEmpleadoTable());
    }

    private DefaultTableModel UpdateEmpleadoTable() {
        
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Empleado> empleados = BD.getAllEmpleados();

        model.addColumn("ID_EMPLEADO");
        model.addColumn("NOMBRES");
        model.addColumn("APELLIDOS");
        model.addColumn("DIRECCION");
        model.addColumn("TELEF");
        model.addColumn("DNI");
        model.addColumn("PUESTO");
        model.addColumn("CORREO");

        for (Empleado e : empleados) {
            model.addRow(new Object[] {
                e.getID(),
                e.getNombres(),
                e.getApellidos(),
                e.getDireccion(),
                e.getTelefono(),
                e.getDNI(),
                e.getPuesto(),
                e.getCorreo()
            });
        }

        return model;
    
    }

    public static class TablaAction implements MouseListener {
        //faltan implementar
        @Override
        public void mouseClicked(MouseEvent arg0) {
            int columna = 2;
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        }



    }


    public class ButtonAdd implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent arg0) {
            GUI_EmpleadosAdd emergente = new GUI_EmpleadosAdd();
            emergente.setButton1ActionListener(new Guardar(emergente,0));
        }
        
    }

    public class ButtonUpdate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            javax.swing.JTable tabla = view.getTable();
            int fila = tabla.getSelectedRow();

            if (fila != -1) {
                try {
                    GUI_EmpleadosAdd emergente = new GUI_EmpleadosAdd();
                    emergente.setFrameName("Actualizar empleado");
                    emergente.setIdField(tabla.getValueAt(fila, 0).toString());
                    emergente.setNameField(tabla.getValueAt(fila, 1).toString());
                    emergente.setSurnameField(tabla.getValueAt(fila, 2).toString());
                    emergente.setDirField(tabla.getValueAt(fila, 3).toString());
                    emergente.setNumField(tabla.getValueAt(fila, 4).toString());
                    emergente.setDniField(tabla.getValueAt(fila, 5).toString());
                    emergente.setPosField(tabla.getValueAt(fila, 6).toString());
                    emergente.setMailField(tabla.getValueAt(fila, 7).toString());
                    emergente.setButton1ActionListener(new Guardar(emergente, 1));
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(view, "Por favor, seleccione una fila para actualizar.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Por favor, seleccione una fila para actualizar.");
            }
        
        }
        
    }

    public class ButtonDelete implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            javax.swing.JTable tabla = view.getTable();
            int fila = tabla.getSelectedRow();

            if (fila != -1) {
                try {
                    BD.DeleteEmpleado((tabla.getValueAt(fila, 0)).toString());
                    UpdateTable();
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(view, "Por favor, seleccione una fila para eliminar.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Por favor, seleccione una fila para eliminar.");
            }
        }

    }

    public class Guardar implements ActionListener {

        private GUI_EmpleadosAdd addon;
        private int mode;

        public Guardar(GUI_EmpleadosAdd panel, int mode) {
            addon = panel;
            this.mode = mode;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            model = new Empleado();

            try {
                model.setID(Integer.parseInt(addon.getIdField()));
                model.setNombres(addon.getNameField());
                model.setApellidos(addon.getSurnameField());
                model.setDireccion(addon.getDirField());
                model.setTelefono(addon.getNumField());
                model.setDNI(Integer.parseInt(addon.getDniField()));
                model.setPuesto(addon.getPosField());
                model.setCorreo(addon.getMailField());

                if (mode == 0) {
                    BD.SaveNewEmpleado(model);
                } else if (mode == 1) {
                    BD.UpdateEmpleado(model);
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
