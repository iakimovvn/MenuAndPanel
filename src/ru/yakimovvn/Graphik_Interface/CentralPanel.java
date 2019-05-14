package ru.yakimovvn.Graphik_Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CentralPanel extends JPanel  implements ActionListener {

     String [][] nameFilesArr = {
            {"irina","Ириночка"},
            {"masha","Машулька"},
            {"volodya","Володя"}};
    private final String TRIP_TXT_FILE = "./text/";
    private String[] txtFilesArr;
    private ImageIcon [] imageFilesArr;
    private JTextPane textPane;

    Color [] centralPanelColor = {Color.WHITE,Color.BLACK,Color.BLUE};

    private JLabel imageLbl;

    private int contentNow = 0;

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("close"))System.exit(0);
        else setContentNow(Integer.parseInt(e.getActionCommand()));
    }

    public void setContentNow(int contentNow){
        this.contentNow = contentNow;
        setContents();
    }

    public int getContentNow(){
        return this.contentNow;
    }



    private ImageIcon [] createImageIconArr(){
        ImageIcon [] resultImageIconArr = new ImageIcon[nameFilesArr.length];
        for (int i = 0; i <resultImageIconArr.length; i++) {
            resultImageIconArr[i] = new ImageIcon(MyFrame.TRIP_IMG_FILE+nameFilesArr[i][0]+".jpg");
        }
        return resultImageIconArr;
    }

    private String [] createTxtFilesArr(){
        String [] resultTxtFilesArr = new String[nameFilesArr.length];
        for (int i = 0; i <resultTxtFilesArr.length; i++) {
            resultTxtFilesArr[i]= "file:"+TRIP_TXT_FILE+nameFilesArr[i][0]+".txt";

        }
        return resultTxtFilesArr;
    }


     void setContents(){
        imageLbl.setIcon(imageFilesArr[contentNow]);

        try{
            textPane.setPage(txtFilesArr[contentNow]);
        }catch(IOException err){
            textPane.setText("Файл не найден");
        }
    }

    public CentralPanel(){

        setLayout(new GridLayout(1,2));
        setBorder(BorderFactory.createEtchedBorder());

        imageFilesArr = createImageIconArr();
        txtFilesArr = createTxtFilesArr();

        imageLbl = new JLabel();
        imageLbl.setHorizontalAlignment(JLabel.CENTER);

        JPopupMenu imageLblPopupMenu = new JPopupMenu();
        JMenuItem [] imageLblPopupMenuItems = new JMenuItem[nameFilesArr.length];
        for (int i = 0; i < nameFilesArr.length; i++) {
            imageLblPopupMenuItems [i]= new JMenuItem(nameFilesArr[i][1]);
            imageLblPopupMenuItems[i].setActionCommand(Integer.toString(i));
            imageLblPopupMenuItems[i].addActionListener(this);
            imageLblPopupMenu.add(imageLblPopupMenuItems[i]);

        }

        imageLblPopupMenu.addSeparator();
        JMenuItem closePopup = new JMenuItem("Закрыть",new ImageIcon(MyFrame.TRIP_IMG_FILE+"close"+".png"));
        closePopup.setActionCommand("close");
        closePopup.addActionListener(this);
        imageLblPopupMenu.add(closePopup);
        imageLbl.setComponentPopupMenu(imageLblPopupMenu);
        add(imageLbl);

        JScrollPane scrollPane = new JScrollPane();
        textPane = new JTextPane();
        textPane.setEditable(false);
        scrollPane.getViewport().add(textPane);
        setContents();
        add(scrollPane);


    }
}
