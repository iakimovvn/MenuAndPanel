package ru.yakimovvn.Graphik_Interface;

import javax.swing.*;
import java.awt.*;

public class MyToolBar extends JToolBar {

    private CentralPanel centralPanel;

    public MyToolBar(CentralPanel centralPanel,String nameToolBar){
        super(nameToolBar);
        this.centralPanel = centralPanel;

        ToolBarButton home = new ToolBarButton("home");
        home.setToolTipText("Домой");
        home.addActionListener(e->{
            centralPanel.setContentNow(0);

        });


        ToolBarButton back = new ToolBarButton("back");
        back.setToolTipText("Назад");
        back.addActionListener(e->{
                int contentNow=centralPanel.getContentNow();
                centralPanel.setContentNow((contentNow ==0)?centralPanel.nameFilesArr.length-1:(--contentNow));
                });

        ToolBarButton front = new ToolBarButton("front");
        front.setToolTipText("Вперед");
        front.addActionListener(e->{
            centralPanel.setContentNow((centralPanel.getContentNow()+1) % centralPanel.nameFilesArr.length);

        });

        ToolBarButton save = new ToolBarButton("save");
        save.setToolTipText("Созранить");
        save.setActionCommand("save");
        save.addActionListener(centralPanel);


        ToolBarButton close = new ToolBarButton("close");
        close.setToolTipText("Закрыть");
        close.setActionCommand("close");
        close.addActionListener(centralPanel);


        add(home);
        add(back);
        add(front);
        add(save);
        add(close);

    }


    private class ToolBarButton extends JButton {
        private ToolBarButton(String nameFileIcon){
            super (new ImageIcon(MyFrame.TRIP_IMG_FILE+nameFileIcon+".png"));
            setFocusPainted(false);
        }
    }


}
