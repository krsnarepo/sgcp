package com.sgcp.Controller.Listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sgcp.Model.DAO.Autenticacion;
import com.sgcp.View.GUILogin;

public class LoginListener implements ActionListener {

    private JPanel contentPane;
    private final GUILogin acceso;
    private Connection bd;
    private Autenticacion auth;

    public LoginListener(GUILogin acceso, JPanel panel, Connection bd) {
        this.bd = bd;
        this.acceso = acceso;
        contentPane = panel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        auth = new Autenticacion(bd);
        if (auth.checkUser(acceso.getField1Text(), acceso.getField2Text())) {//Cambiar a true si no existen empleados en la bd
            acceso.setSuccess();
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Menu Principal");
        }
        else {
            JOptionPane.showMessageDialog(acceso, "Usuario y contraseña no encontrados",
                                        "ADVERTENCIA",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
