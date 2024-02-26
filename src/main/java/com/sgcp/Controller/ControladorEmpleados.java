package com.sgcp.Controller;
import com.sgcp.Model.FactoryPersonas.GeneralPersonFactory;
import com.sgcp.View.GUI_Empleados;
import com.sgcp.View.GUI_EmpleadosAdd;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.sgcp.Model.FactoryPersonas.ClientFactory;
import com.sgcp.Model.FactoryPersonas.EmployeeFactory;

public class ControladorEmpleados {
    
    private Connection bd;
    private JPanel contentPane;
    GeneralPersonFactory persona;
    
    public ControladorEmpleados(GUI_Empleados m, JPanel panel, Connection bd) {
        contentPane = panel;
        this.bd = bd;
        m.Table1SetModel(UpdateEmpleadoTable());
    }

    private DefaultTableModel UpdateEmpleadoTable() {
        
        DefaultTableModel model;
        String Query = "SELECT * FROM EMPLEADO";
        String[] row = new String[10];

        try {
            Statement st = (Statement) bd.createStatement();          
            ResultSet rs = st.executeQuery(Query);
            ResultSetMetaData m = rs.getMetaData();          
            int n = m.getColumnCount();           
            String[] s = new String[n];           

            for (int i = 0; i < n; i++)
                s[i] = m.getColumnName(i+1);    

            model = new DefaultTableModel(null,s);

            while (rs.next()) {
                for (int i = 0; i < s.length; i++)
                    row[i] = rs.getString(s[i]);
                model.addRow(row);
            }
            return model;

        } catch (SQLException e) {
            return null;
        }
    
    }

    public static class TablaAction implements MouseListener {

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
