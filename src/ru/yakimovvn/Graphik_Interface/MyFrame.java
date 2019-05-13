package ru.yakimovvn.Graphik_Interface;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    static final String TRIP_FILE = "./img/";
    CentralPanel panel;

    public MyFrame(String windowName){
        super(windowName);
        setResizable(true);
        setLayout(new BorderLayout());
        setBounds(250,250,500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JButton closeButton = new JButton("CLOSE");
        closeButton.setSize(new Dimension(100,30));
        closeButton.addActionListener(e -> System.exit(0));
        closeButton.setFocusPainted(false);
        closeButton.setOpaque(true);
        closeButton.setContentAreaFilled(true);
        add(closeButton,BorderLayout.SOUTH);

        setVisible(true);

    }
}
