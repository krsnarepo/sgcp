package com.sgcp.Controller.Listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class BackToMenuListener implements ActionListener {

    private JPanel contentPane;

    public BackToMenuListener(JPanel panel) {
        contentPane = panel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "Menu Principal");
    }
    
}
