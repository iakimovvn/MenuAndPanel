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
            centralPanel.contentNow = 0;
            centralPanel.setContents();
        });

        ToolBarButton back = new ToolBarButton("back");
        back.setToolTipText("Назад");
        back.addActionListener(e->{
            centralPanel.contentNow =(centralPanel.contentNow ==0)?2:--centralPanel.contentNow;
            centralPanel.setContents();
        });

        ToolBarButton front = new ToolBarButton("front");
        front.setToolTipText("Вперед");
        front.addActionListener(e->{
            centralPanel.contentNow =(centralPanel.contentNow ==2)?0:++centralPanel.contentNow;
            centralPanel.setContents();
        });

        ToolBarButton close = new ToolBarButton("close");
        close.setToolTipText("Закрыть");
        close.addActionListener(e-> System.exit(0));


        add(home);
        add(back);
        add(front);
        add(close);

    }


    private class ToolBarButton extends JButton {
        private ToolBarButton(String nameFileIcon){
            super (new ImageIcon(MyFrame.TRIP_IMG_FILE+nameFileIcon+".png"));
            setFocusPainted(false);
        }
    }


}
