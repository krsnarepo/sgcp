package com.sgcp.View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUICitasEmergente extends JFrame {

    private void init() {

        this.setName("Añadir cita");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




    }

    

    public String getIdField() {
        return idField.getText();
    }

    public String getIdClField() {
        return idClField.getText();
    }

    public String getDateField() {
        return dateField.getText();
    }

    public String getIdEmField() {
        return idEmField.getText();
    }



    private JLabel idLabel;
    private JLabel idClLabel;
    private JLabel dateLabel;
    private JLabel idEmLabel;

    private JTextField idField;
    private JTextField idClField;
    private JTextField dateField;
    private JTextField idEmField;

    private JButton acceptButton;

    
}
