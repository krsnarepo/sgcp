package com.sgcp.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIEmpleadosEmergente extends JFrame {

    public GUIEmpleadosEmergente() {
        GuardarDialog();
    }
    
    private void GuardarDialog() {  

        this.setName("Añadir empleado");
        this.setPreferredSize(new Dimension(400,300));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new BoxLayout(panelLabels, BoxLayout.Y_AXIS));

        // Crear componentes para el formulario
        idLabel = new JLabel("ID_PACIENTE");
        nameLabel = new JLabel("NOMBRES:");
        surnameLabel = new JLabel("APELLIDOS:");
        dirLabel = new JLabel("DIRECCION:");
        numLabel = new JLabel("TELEFONO:");
        dniLabel = new JLabel("DNI:");
        posLabel = new JLabel("PUESTO:");
        mailLabel = new JLabel("CORREO:");

        panelLabels.add(idLabel);
        panelLabels.add(nameLabel);
        panelLabels.add(surnameLabel);
        panelLabels.add(dirLabel);
        panelLabels.add(numLabel);
        panelLabels.add(dniLabel);
        panelLabels.add(posLabel);
        panelLabels.add(mailLabel);

        JPanel panelTextFields = new JPanel();
        panelTextFields.setLayout(new BoxLayout(panelTextFields, BoxLayout.Y_AXIS));

        idField = new JTextField(20);
        nameField = new JTextField(20);
        surnameField = new JTextField(20);
        dirField = new JTextField(20);
        numField = new JTextField(20);
        dniField = new JTextField(20);
        posField = new JTextField(20);
        mailField = new JTextField(20);

        panelTextFields.add(idField);
        panelTextFields.add(nameField);
        panelTextFields.add(surnameField);
        panelTextFields.add(dirField);
        panelTextFields.add(numField);
        panelTextFields.add(dniField);
        panelTextFields.add(posField);
        panelTextFields.add(mailField);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Crear un botón para aceptar el formulario
        acceptButton = new JButton("Aceptar");

        panelBoton.add(acceptButton);

        // Crear un panel para organizar los componentes
        panelPrincipal.add(panelLabels, BorderLayout.WEST);
        panelPrincipal.add(panelTextFields, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        this.add(panelPrincipal);
        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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

    public void setFrameName(String name) {
        this.setName(name);
    }

    public void setIdField(String idField) {
        this.idField.setText(idField);
    }

    public void setNameField(String nameField) {
        this.nameField.setText(nameField);
    }

    public void setSurnameField(String surnameField) {
        this.surnameField.setText(surnameField);
    }

    public void setDirField(String dirField) {
        this.dirField.setText(dirField);
    }

    public void setNumField(String numField) {
        this.numField.setText(numField);
    }

    public void setDniField(String dniField) {
        this.dniField.setText(dniField);
    }

    public void setPosField(String posField) {
        this.posField.setText(posField);
    }

    public void setMailField(String mailField) {
        this.mailField.setText(mailField);
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
