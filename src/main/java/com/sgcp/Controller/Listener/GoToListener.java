package com.sgcp.Controller.Listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GoToListener implements ActionListener {

    private String option;
    private JPanel contentPane;

    public GoToListener(String option, JPanel panel) {
        this.option = option;
        contentPane = panel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, option);
        contentPane.setPreferredSize(null);
    }
    
}
