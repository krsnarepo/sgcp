package com.sgcp.Controller;
import com.sgcp.Model.Empleado;
import com.sgcp.Model.DAO.OperacionesBD;
import com.sgcp.View.GUI_Empleados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

    public static class ButtonAddEmpleado implements ActionListener {

        //Codigo de ejepmlo para incluir JDialog en JFrame
        //Está por mientras, deberia todo esto implementarse en una clase aparte que sea del paquete View
        @Override
        public void actionPerformed(ActionEvent event) {

            JFrame frame = new JFrame("Ventana Principal");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JDialog dialog = new JDialog(frame, "Diálogo Modal", true);
            dialog.setSize(300, 200);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            // Crear componentes para el formulario
            JLabel nameLabel = new JLabel("Nombre:");
            JTextField nameField = new JTextField(20);
            JLabel ageLabel = new JLabel("Edad:");
            JTextField ageField = new JTextField(3);

            // Crear un botón para aceptar el formulario
            JButton acceptButton = new JButton("Aceptar");
            acceptButton.addActionListener(new Guardar(frame));

            // Crear un panel para organizar los componentes
            JPanel panel = new JPanel();
            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(ageLabel);
            panel.add(ageField);
            panel.add(acceptButton);

            // Agregar el panel al contenido del diálogo
            dialog.add(panel);

            // Centrar el diálogo en la pantalla
            dialog.setLocationRelativeTo(frame);

            // Hacer visible el diálogo
            dialog.setVisible(true);
        }
        
    }

    public static class Guardar implements ActionListener {

        private JFrame ventana;

        public Guardar(JFrame emergente) {
            ventana = emergente;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            //Se podria obtener los campos ingresados creando getters para los jTextField
            ventana.dispose();
        }

    }

}
