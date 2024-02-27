package com.sgcp.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sgcp.Controller.ControladorPrincipal;
//import com.sgcp.Controller.test.GoToListener;

public class GUIPrincipal extends javax.swing.JPanel {

    private JPanel contentPane;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;

    private javax.swing.JPanel buttonPanel;
    
    public GUIPrincipal(JPanel panel){
        contentPane = panel;
        init();
    }
    
    private void init() {
        
        buttonPanel = new JPanel(new GridLayout(2, 2));

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();


        jLabel1.setText("SISTEMA DE GESTION CLÍNICO ÓPTICO ");
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        
        jButton1.setText("Trabajadores");
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabajadores.png")));
        jButton1.addActionListener(new ControladorPrincipal.GoTo("Empleados", contentPane));

        jButton2.setText("Resultados");
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prescripcion.png")));
        jButton2.addActionListener(new ControladorPrincipal.GoTo("Resultados", contentPane));

        jButton3.setText("Pagos");
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pagos.png")));
        jButton3.addActionListener(new ControladorPrincipal.GoTo("Pagos", contentPane));

        jButton4.setText("Clientes");
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente.png")));
        jButton4.addActionListener(new ControladorPrincipal.GoTo("Clientes", contentPane));

        jButton5.setText("Programacion");
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prog_cita.png")));
        jButton5.addActionListener(new ControladorPrincipal.GoTo("Citas", contentPane));

        jButton6.setText("Inventario");
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario.png")));
        jButton6.addActionListener(new ControladorPrincipal.GoTo("Inventario", contentPane));

        jButton7.setText("Consultas");
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/examen-medico.png")));
        jButton7.addActionListener(new ControladorPrincipal.GoTo("Consultas", contentPane));

        jButton8.setText("Pedidos");
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gafas.png")));
        jButton8.addActionListener(new ControladorPrincipal.GoTo("Pedidos", contentPane));

        setLayout(new BorderLayout());
        add(jLabel1, BorderLayout.NORTH);

        buttonPanel.add(jButton1);
        buttonPanel.add(jButton2);
        buttonPanel.add(jButton3);
        buttonPanel.add(jButton4);
        buttonPanel.add(jButton5);
        buttonPanel.add(jButton6);
        buttonPanel.add(jButton7);
        buttonPanel.add(jButton8);

        add(buttonPanel, BorderLayout.CENTER);

    }// </editor-fold>

}
