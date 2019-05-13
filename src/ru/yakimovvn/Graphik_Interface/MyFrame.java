package ru.yakimovvn.Graphik_Interface;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(String windowName){
        super(windowName);
        setResizable(true);
        setBounds(250,250,500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
}
