package ru.yakimovvn.Graphik_Interface;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {


    CentralPanel centralPanel;

    public MyFrame(String windowName){
        super(windowName);
        setResizable(true);
        setLayout(new BorderLayout());
        setBounds(250,250,500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        centralPanel = new CentralPanel();
        add(centralPanel,BorderLayout.CENTER);


        JButton closeButton = new JButton("CLOSE");
        JPanel panelForButtonClose = new JPanel();
        panelForButtonClose.setLayout(new GridLayout(1,3));
        closeButton.addActionListener(e -> System.exit(0));
        closeButton.setFocusPainted(false);
        closeButton.setOpaque(true);
        closeButton.setContentAreaFilled(true);
        panelForButtonClose.add(new JLabel());
        panelForButtonClose.add(closeButton);
        panelForButtonClose.add(new JLabel());
        add(panelForButtonClose,BorderLayout.SOUTH);

        setVisible(true);

    }
}
