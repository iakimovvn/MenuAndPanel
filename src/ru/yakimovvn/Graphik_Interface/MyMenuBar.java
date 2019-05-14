package ru.yakimovvn.Graphik_Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyMenuBar extends JMenuBar implements ActionListener {
    private CentralPanel centralPanel;

    public void actionPerformed(ActionEvent e){
        centralPanel.contentNow = Integer.parseInt(e.getActionCommand());
        centralPanel.setContents();
    }

    public MyMenuBar(CentralPanel centralPanel){

        this.centralPanel = centralPanel;

        JMenu content = new JMenu("Содержание");
        JMenuItem [] contentItem = new JMenuItem[centralPanel.nameFilesArr.length];
        for (int i = 0; i <centralPanel.nameFilesArr.length ; i++) {
            contentItem[i] = new JMenuItem(centralPanel.nameFilesArr[i][1]);
            contentItem[i].setActionCommand(Integer.toString(i));
            contentItem[i].addActionListener(this);
            content.add(contentItem[i]);
            if(i<centralPanel.nameFilesArr.length-1)content.addSeparator();

        }
        add(content);


        JMenu view = new JMenu("Вид");
        JCheckBoxMenuItem blockChangeColor = new JCheckBoxMenuItem("Цвет панели",true);
        view.add(blockChangeColor);
        view.addSeparator();

        JRadioButtonMenuItem white = new JRadioButtonMenuItem(" Белый",true);
        JRadioButtonMenuItem black = new JRadioButtonMenuItem(" Черный",false);
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Синий",false);
        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(white);
        colorGroup.add(black);
        colorGroup.add(blue);
        blockChangeColor.addActionListener(e->{
            if(blockChangeColor.isSelected()){
                white.setEnabled(true);
                black.setEnabled(true);
                blue.setEnabled(true);
            }else{
                white.setEnabled(false);
                black.setEnabled(false);
                blue.setEnabled(false);
            }
        });

        white.addActionListener(e->centralPanel.setBackground(centralPanel.centralPanelColor[0]));
        black.addActionListener(e->centralPanel.setBackground(centralPanel.centralPanelColor[1]));
        blue.addActionListener(e->centralPanel.setBackground(centralPanel.centralPanelColor[2]));
        view.add(white);
        view.add(black);
        view.add(blue);

        add(view);


        JMenu program = new JMenu("Программа");

        JMenuItem aboutProgram = new JMenuItem("О программе");
        aboutProgram.addActionListener(e->JOptionPane.showMessageDialog(null,
                "В этой программе используется панель меню,\nи панель инструментов",
                "О Программе",JOptionPane.INFORMATION_MESSAGE));
        program.add(aboutProgram);

        program.addSeparator();

        JMenuItem exit = new JMenuItem("Выход",new ImageIcon(MyFrame.TRIP_IMG_FILE+"close.png"));
        exit.addActionListener(e->System.exit(0));
        program.add(exit);

        add(program);

    }
}
