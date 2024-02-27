package com.sgcp.View;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sgcp.Controller.ControladorEmpleados.Guardar;

public class GUI_EmpleadosAdd extends JDialog {

    public GUI_EmpleadosAdd() {
        GuardarDialog();
    }
    
    private void GuardarDialog() {  

        JFrame frame = new JFrame("Añadir empleado");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear componentes para el formulario
        idLabel = new JLabel("ID_PACIENTE");
        nameLabel = new JLabel("NOMBRES:");
        surnameLabel = new JLabel("APELLIDOS:");
        dirLabel = new JLabel("DIRECCION");
        numLabel = new JLabel("TELEFONO");
        dniLabel = new JLabel("DNI");
        posLabel = new JLabel("PUESTO");
        mailLabel = new JLabel("CORREO");

        idField = new JTextField(30);
        nameField = new JTextField(30);
        surnameField = new JTextField(30);
        dirField = new JTextField(30);
        numField = new JTextField(30);
        dniField = new JTextField(30);
        posField = new JTextField(30);
        mailField = new JTextField(30);

        // Crear un botón para aceptar el formulario
        acceptButton = new JButton("Aceptar");

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(surnameLabel);
        panel.add(surnameField);
        panel.add(dirLabel);
        panel.add(dirField);
        panel.add(numLabel);
        panel.add(numField);
        panel.add(dniLabel);
        panel.add(dniField);
        panel.add(posLabel);
        panel.add(posField);
        panel.add(mailLabel);
        panel.add(mailField);

        panel.add(acceptButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public String getIdField() {
        return idField.getText();
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getSurnameField() {
        return surnameField.getText();
    }

    public String getDirField() {
        return dirField.getText();
    }

    public String getNumField() {
        return numField.getText();
    }

    public String getDniField() {
        return dniField.getText();
    }

    public String getPosField() {
        return posField.getText();
    }

    public String getMailField() {
        return mailField.getText();
    }

    public void setButton1ActionListener(ActionListener action) {
        acceptButton.addActionListener(action);
    }

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel dirLabel;
    private JLabel numLabel;
    private JLabel dniLabel;
    private JLabel posLabel;
    private JLabel mailLabel;

    private JTextField idField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField dirField;
    private JTextField numField;
    private JTextField dniField;
    private JTextField posField;
    private JTextField mailField;

    private JButton acceptButton;

}
