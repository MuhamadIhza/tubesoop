import javax.swing.*;  
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.io.*;
import java.net.*;


public class Board {
    JFrame f = new JFrame("KELOMPOK 1 PLANT VS ZOMBIE: A VERY BOOTLEG EDITION");//creating instance of JFrame  
    static int horizontal = 16;
    static int vertical = 7;
    JButton[][] matrixButton = new JButton[vertical][horizontal];

    public Board(){
    //GRID PLANT ZOMBIES
        int x=0;
        int y=0;
        for (int i=0; i<=vertical-1; i++){  
            for (int j=0; j<=horizontal-1; j++){
    
                //ImageIcon leftButtonIcon = new ImageIcon("peashooter.gif");
                //matrixButton[i][j] = new JButton(leftButtonIcon);
                matrixButton[i][j] = new JButton();
                matrixButton[i][j].setBounds(70*j,70*i,70, 70);//x axis, y axis, width, height 
    
                if ((x%2 == 0) && (y%2 == 0)){
                    matrixButton[i][j].setBackground(new Color(153,102,51));
                    matrixButton[i][j].setForeground(Color.BLACK); 
                }
                else if ((x%2 == 0) && (y%2 == 1)){
                    matrixButton[i][j].setBackground(Color.GREEN);
                    matrixButton[i][j].setForeground(Color.BLACK); 
                }
                else if ((x%2 == 1) && (y%2 == 1)){
                    matrixButton[i][j].setBackground(new Color(153,102,51));
                    matrixButton[i][j].setForeground(Color.BLACK); 
                }
                else if ((x%2 == 1) && (y%2 == 0)){
                    matrixButton[i][j].setBackground(Color.GREEN);
                    matrixButton[i][j].setForeground(Color.BLACK); 
                }
                f.add(matrixButton[i][j]);//adding button in JFrame 
                x += 1;
            } 
            y += 1;
        }
    //GRID PLANT ZOMBIES

    //PANEL STAT
        JPanel panelSTAT=new JPanel();  
        panelSTAT.setBounds(480,490,1020,320);    //x axis, y axis, width, height 
        panelSTAT.setBackground(Color.LIGHT_GRAY);
        f.add(panelSTAT);

        JLabel statLabel = new JLabel("ASPECT STAT\n");
        statLabel.setFont(statLabel.getFont().deriveFont(32f));
        statLabel.setForeground(Color.BLACK);
        panelSTAT.add(statLabel);
    //PANEL STAT

    //PANEL BELI TANAMAN
        JPanel panelTANAMAN=new JPanel();  
        JLabel beli = new JLabel("BUY PLANT");
        beli.setFont(beli.getFont().deriveFont(32f));
        beli.setForeground(Color.YELLOW);
        panelTANAMAN.add(beli);

        panelTANAMAN.setBounds(0,490,240,320);    //x axis, y axis, width, height 
        panelTANAMAN.setBackground(Color.DARK_GRAY);
        f.add(panelTANAMAN);
        ImageIcon cardPeaImage = new ImageIcon("card_peashooter.png");
        ImageIcon cardPeaFreezeImage = new ImageIcon("card_freezepeashooter.png");
        JButton cardPea = new JButton(cardPeaImage);
        JButton cardPeaFreeze = new JButton(cardPeaFreezeImage);

        cardPea.setBounds(40,600,65,90);//x axis, y axis, width, height 
        cardPeaFreeze.setBounds(120,600,65,90);//x axis, y axis, width, height
        f.add(cardPea); 
        f.add(cardPeaFreeze);

        JLabel sunscoreLabel = new JLabel("your sunscore:");
        Dimension size1 = sunscoreLabel.getPreferredSize();
        sunscoreLabel.setFont(sunscoreLabel.getFont().deriveFont(16f));
        sunscoreLabel.setForeground(Color.BLACK);
        sunscoreLabel.setBounds(160,570,size1.width,size1.height);
        //panelTANAMAN.setLayout(null);
        panelTANAMAN.add(sunscoreLabel);

        int sunscore = 100; //GANTI!
        JLabel nilaisunscoreLabel = new JLabel();
        Dimension size2 = nilaisunscoreLabel.getPreferredSize();
        nilaisunscoreLabel.setText(String.valueOf(sunscore));
        nilaisunscoreLabel.setBackground(Color.GREEN);
        nilaisunscoreLabel.setFont(nilaisunscoreLabel.getFont().deriveFont(16f));
        nilaisunscoreLabel.setForeground(Color.YELLOW);
        nilaisunscoreLabel.setBounds(160,570,size2.width,size2.height);
        //panelTANAMAN.setLayout(null);
        panelTANAMAN.add(nilaisunscoreLabel);
    //PANEL BELI TANAMAN

    //PANEL END GAME
        JPanel panelCHOICE =new JPanel();  
        panelCHOICE.setBounds(240,490,240,320);    //x axis, y axis, width, height 
        panelCHOICE.setBackground(new Color(153,153,102));

        JLabel choiceLabel = new JLabel("END GAME?");
        choiceLabel.setFont(choiceLabel.getFont().deriveFont(32f));
        choiceLabel.setForeground(Color.BLACK);
        panelCHOICE.add(choiceLabel);
        f.add(panelCHOICE);
        JButton endChoose = new JButton("END");
        endChoose.setBackground(new Color(215,215,193));
        endChoose.setBounds(270,545,180,185);//x axis, y axis, width, height
        f.add(endChoose);
    //PANEL END GAME

    //FRAME
    f.setSize(1130,800);//400 width and 500 height  
    f.setLayout(null);//using no layout managers  
    f.setVisible(true);//making the frame visible  
    //FRAME
    }

    public void addPlantToButton(int choice, int x, int y){
        if (choice == 1){
            ImageIcon buttonIcon = new ImageIcon("peashooter.gif");
            matrixButton[y][x] = new JButton(buttonIcon);
        }
        else if (choice == 2){
            ImageIcon buttonIcon = new ImageIcon("freezepeashooter.gif");
            matrixButton[y][x] = new JButton(buttonIcon);
        }
    }

    public void movePeluruOnButton(int jenispeluru){
        ImageIcon buttonIcon = new ImageIcon("pea.png");

        for (int i=0; i<=vertical-1; i++){
            for (int j=0; j<=horizontal-1; j++){
                if (matrixButton[i][j].getIcon().equals(buttonIcon)){

                }
            }
        }
        
    }


}