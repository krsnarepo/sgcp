package com.sgcp.View;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sgcp.Controller.ControladorEmpleados;

import oracle.jdbc.datasource.impl.OracleDataSource;

public class MainFrame implements Runnable{

    private Connection bd = null;
    private JPanel contentPane;
    private GUI_Login LogPanel;
    private GUI_Principal MainPanel;
    private GUI_Empleados EmpPanel;
    private GUI_Citas CitPanel;
    private GUI_Clientes CliPanel;
    private GUI_Inventario InvPanel;
    private GUI_Pagos PagPanel;
    private GUI_Pedidos PedPanel;
    private GUI_Resultados ResPanel; 

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
            CitPanel = new GUI_Citas(contentPane, bd);
            CliPanel = new GUI_Clientes(contentPane, bd);
            InvPanel = new GUI_Inventario(contentPane, bd);
            PagPanel = new GUI_Pagos(contentPane, bd);
            PedPanel = new GUI_Pedidos(contentPane, bd);
            ResPanel = new GUI_Resultados(contentPane, bd);

            //new ControladorPrincipal(MainPanel, contentPane);
            new ControladorEmpleados(EmpPanel, contentPane, bd);

            contentPane.add(LogPanel, "Login");
            contentPane.add(MainPanel, "Menu Principal");
            contentPane.add(EmpPanel, "Empleados");
            contentPane.add(CitPanel, "Citas");
            contentPane.add(CliPanel, "Clientes");
            contentPane.add(InvPanel, "Inventario");
            contentPane.add(PagPanel, "Pagos");
            contentPane.add(PedPanel, "Pedidos");
            contentPane.add(ResPanel, "Resultados");
            
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
