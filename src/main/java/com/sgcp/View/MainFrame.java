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
    private GUILogin LogPanel;
    private GUIPrincipal MainPanel;
    private GUIEmpleados EmpPanel;
    private GUICitas CitPanel;
    private GUIClientes CliPanel;
    private GUIInventario InvPanel;
    private GUIPagos PagPanel;
    private GUIPedidos PedPanel;
    private GUIResultados ResPanel; 

    public void display() {

        JFrame ventana = new JFrame("SGCP");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        contentPane.setLayout(new CardLayout());

        bd = CrearConexion();

        if (bd != null) {
            
            LogPanel = new GUILogin(ventana,contentPane,bd);
            MainPanel = new GUIPrincipal(contentPane);
            EmpPanel = new GUIEmpleados(contentPane,bd);
            CitPanel = new GUICitas(contentPane, bd);
            CliPanel = new GUIClientes(contentPane, bd);
            InvPanel = new GUIInventario(contentPane, bd);
            PagPanel = new GUIPagos(contentPane, bd);
            PedPanel = new GUIPedidos(contentPane, bd);
            ResPanel = new GUIResultados(contentPane, bd);

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
