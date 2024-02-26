package com.sgcp.View;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sgcp.Controller.ControladorEmpleados;

public class GUI_EmpleadosAdd extends JFrame{

    private JButton jButton1;
    private JPanel contentPane;

    public GUI_EmpleadosAdd() {
        this.setSize(200,400);
        initComponents();
    }
    
    private void initComponents() {
        jButton1 = new JButton();

        jButton1.setText("Guardar");
        jButton1.addActionListener(new ControladorEmpleados.Guardar(this));

        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        contentPane.setLayout(new GridLayout());

        contentPane.add(jButton1);
        
        this.setContentPane(contentPane);
        this.pack();
        this.setLocationByPlatform(true);
    }

}
