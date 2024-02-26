package com.sgcp.View;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sgcp.Controller.ControladorEmpleados;
import com.sgcp.Controller.ControladorPrincipal;

import oracle.jdbc.datasource.impl.OracleDataSource;

public class MainFrame implements Runnable{

    private Connection bd = null;
    private JPanel contentPane;
    private GUI_Login LogPanel;
    private GUI_Principal MainPanel;
    private GUI_Empleados EmpPanel;

    public void display() {

        JFrame ventana = new JFrame("SGCP");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        contentPane.setLayout(new CardLayout());

        bd = CrearConexion();

        if (bd != null) {
            
            LogPanel = new GUI_Login(ventana,contentPane,bd);
            MainPanel = new GUI_Principal(contentPane);
            EmpPanel = new GUI_Empleados(contentPane,bd);
            

            //new ControladorPrincipal(MainPanel, contentPane);
            new ControladorEmpleados(EmpPanel, contentPane, bd);

            contentPane.add(LogPanel, "Login");
            contentPane.add(MainPanel, "Menu Principal");
            contentPane.add(EmpPanel, "Empleados");
            
            ventana.setContentPane(contentPane);

            ventana.pack();
            ventana.setLocationByPlatform(true);
            ventana.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null,"Imposible conectar a la base de datos",
                                        "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Connection CrearConexion() {
        try {
            OracleDataSource ods = new OracleDataSource();
            //Conexión por defecto para la base de datos
            String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
            ods.setURL(url);
            //Aquí va el usuario y contraseña que hayan creado o el por defecto
            ods.setUser("sgcp_man");
            ods.setPassword("sgcp_man");
            bd = ods.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bd;
    }

    @Override
    public void run() {
        new MainFrame().display();
    }
    
}
