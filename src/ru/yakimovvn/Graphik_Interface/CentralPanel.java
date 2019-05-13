package ru.yakimovvn.Graphik_Interface;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CentralPanel extends JPanel {

    private String [][] nameFilesArr = {
            {"irina","Ириночка"},
            {"masha","Машулька"},
            {"volodya","Володя"}};
    private final String TRIP_IMG_FILE = "./img/";
    private final String TRIP_TXT_FILE = "./text/";
    private String[] txtFilesArr;
    private ImageIcon [] imageFilesArr;
    JTextPane textPane;

    JLabel imageLbl;

    int contentNow = 0;



    private ImageIcon [] createImageIconArr(){
        ImageIcon [] resultImageIconArr = new ImageIcon[nameFilesArr.length];
        for (int i = 0; i <resultImageIconArr.length; i++) {
            resultImageIconArr[i] = new ImageIcon(TRIP_IMG_FILE+nameFilesArr[i][0]+".jpg");
        }
        return resultImageIconArr;
    }

    private String [] createTxtFilesArr(){
        String [] resultTxtFilesArr = new String[nameFilesArr.length];
        for (int i = 0; i <resultTxtFilesArr.length; i++) {
            resultTxtFilesArr[i]= TRIP_TXT_FILE+nameFilesArr[i][0]+".txt";

        }
        return resultTxtFilesArr;
    }


    private void setContents(){
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
        add(imageLbl);

        JScrollPane scrollPane = new JScrollPane();
        textPane = new JTextPane();
        textPane.setEditable(false);
        scrollPane.getViewport().add(textPane);
        setContents();
        add(scrollPane);


    }
}
