package com.sgcp.Controller.Listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sgcp.View.GUI_Login;

public class LoginListener implements ActionListener {

    private JPanel contentPane;
    private final GUI_Login acceso;
    private Connection bd;

    public LoginListener(GUI_Login acceso, JPanel panel, Connection bd) {
        this.bd = bd;
        this.acceso = acceso;
        contentPane = panel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (true) {//checkUser(acceso.getField1Text(), acceso.getField2Text())
            acceso.setSuccess();
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Menu Principal");
        }
        else {
            JOptionPane.showMessageDialog(acceso, "Usuario y contraseña no encontrados",
                                        "ADVERTENCIA",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Boolean checkUser(String user, String password) {

        Boolean check = false;
        String Query = "SELECT COUNT(*) FROM USERS WHERE user = " + acceso.getField1Text()
                        + " AND password = " + acceso.getField2Text();
        try {
            Statement statement = (Statement) bd.createStatement();
            ResultSet result = statement.executeQuery(Query);
            result.next();
            int count = result.getInt(1);
            check = count > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return check;
        
    }
    
}
