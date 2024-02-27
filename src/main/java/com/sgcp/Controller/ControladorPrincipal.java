package com.sgcp.Controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.sgcp.View.GUIPrincipal;

public class ControladorPrincipal {
    
    private GUIPrincipal view;
    private JPanel contentPane;

    public ControladorPrincipal(GUIPrincipal vista, JPanel panel) {
        view = vista;
        contentPane = panel;

        //view.addAction(new InnerPrincipalController("asdasd", KeyEvent.VK_C));
    }

    private class InnerPrincipalController extends AbstractAction {

        public InnerPrincipalController(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Empleados");
        }
    }

    public static class GoTo implements ActionListener {

        private String option;
        private JPanel contentPane;

        public GoTo(String option, JPanel panel) {
            this.option = option;
            contentPane = panel;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, option);
        }
        
    }

}
