package ru.yakimovvn.Graphik_Interface;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(String windowName){
        super(windowName);
        setResizable(true);
        setLayout(new BorderLayout());
        setBounds(250,250,500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

    }
}
