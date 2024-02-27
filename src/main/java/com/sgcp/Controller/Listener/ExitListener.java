package com.sgcp.Controller.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.sgcp.View.GUILogin;

public class ExitListener implements ActionListener {
    
    private JFrame window;
    private final GUILogin acceso;

    public ExitListener(JFrame ventana, GUILogin acceso) {
        window = ventana;
        this.acceso = acceso;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }  

}
