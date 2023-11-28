import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.util.*;

public class dadu{
    public JFrame frame;
    int dadu1,dadu2,P1=10,P2=10,hasilRoll,i=0,clickcount,win1,win2;
    String temp,temp2;
    JButton roll = new JButton();
    JLabel jawaban = new JLabel();
    JLabel winn1 = new JLabel();
    JLabel winn2 = new JLabel();
    ImageIcon Layer1 = new ImageIcon("dice1.png");
    JLabel Dice1 = new JLabel(Layer1);
    ImageIcon Layer2 = new ImageIcon("dice6.png");
    JLabel Dice2 = new JLabel(Layer2);
    JLabel Player1= new JLabel();

    JRadioButton kurang = new JRadioButton ();
    JRadioButton lebih  = new JRadioButton ();
    ButtonGroup kelompok=new ButtonGroup();
    ImageIcon d1 = new ImageIcon("dice1.png");
    ImageIcon d2 = new ImageIcon("dice2.png");
    ImageIcon d3 = new ImageIcon("dice3.png");
    ImageIcon d4 = new ImageIcon("dice4.png");
    ImageIcon d5 = new ImageIcon("dice5.png");
    ImageIcon d6 = new ImageIcon("dice6.png");
    private Game game = new Game();

    Font font = new Font("Felix Titling", Font.BOLD, 20);
    public dadu(){
        makeFrame();
        frame.setVisible(true);

    }

    public void setVisible(boolean visible)
    {
        frame.setVisible(visible);
    }

    public void makeFrame(){
        frame = new JFrame("ADA TERORIST");
        frame.setSize(300,300);
        komponenVisual();

        rolldice();
    }

    private void komponenVisual(){
        JPanel panel = (JPanel)frame.getContentPane();
        panel.setLayout(null);

        roll= new JButton();
        roll.setBounds(150,220,100,30);
        roll.setText("ROLL");
        roll.setFont(font);
        roll.setBackground(SystemColor.red);
        panel.add(roll);


        panel.add(Dice1);
        Dice1.setBounds(0,80,100,100);

        panel.add(Dice2);
        Dice2.setBounds(120,80,100,100);


        panel.add(kurang);
        kurang.setBounds(10,40,100,20);
        kurang.setText("kurang dari 7");

        panel.add(lebih);
        lebih.setBounds(10,10,100,20);
        lebih.setText("Lebih dari 7");

        kelompok.add(kurang);
        kelompok.add(lebih);

        panel.add(jawaban);
        jawaban.setBounds(275,415,50,50);

    }
    //method untuk action listener saat button roll di klik
    public void rolldice(){
        roll.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Lroll();
                    Rroll();
                    hasilRoll=dadu1+dadu2;
                    jawaban.setText(" "+hasilRoll);
                    jawaban.setFont(font);
                    score();
                }
            });
    }
    //method untuk score
    public void score(){

        if(hasilRoll>7){
            if(lebih.isSelected()==true){
                JOptionPane.showMessageDialog(null, "Selamat, anda berhasil lolos dari musuh!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
                game.setTidakAdaMusuh();
            }
            else{
                JOptionPane.showMessageDialog(null, "Maaf, jawaban Anda Salah!\nAnda diculik oleh terorist!", "Salah!!", JOptionPane.ERROR_MESSAGE);
                game.backToEntranceStartRoom();
                //chard.setBounds(187,272,20,20);
                game = new Game();
            }
        }

        else if(hasilRoll<7){
            if(kurang.isSelected()==true){
                JOptionPane.showMessageDialog(null, "Selamat, anda berhasil lolos dari musuh!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);

                game.setTidakAdaMusuh();
            }
            else{
                JOptionPane.showMessageDialog(null, "Maaf, jawaban Anda Salah!\nAnda diculik oleh terorist!", "Salah!!", JOptionPane.ERROR_MESSAGE);
                game.backToEntranceStartRoom();
                //chard.setBounds(187,272,20,20);
                game = new Game();
            }
        }

    }
    //method untuk mengocok dadu kiri
    public void Lroll(){
        dadu1 = (int)(Math.random()*6) + 1;
        if(dadu1==1){
            Dice1.setIcon(d1);
        }
        else if(dadu1==2){
            Dice1.setIcon(d2);
        }

        else if(dadu1==3){
            Dice1.setIcon(d3);
        }
        else if(dadu1==4){
            Dice1.setIcon(d4);
        }
        else if(dadu1==5){
            Dice1.setIcon(d5);
        }
        else if(dadu1==6){
            Dice1.setIcon(d6);
        }

    }
    //method untuk mengocok dadu kanan
    public void Rroll(){
        dadu2 = (int)(Math.random()*6) + 1;
        if(dadu2==1){
            Dice2.setIcon(d1);
        }
        else if(dadu2==2){
            Dice2.setIcon(d2);
        }

        else if(dadu2==3){
            Dice2.setIcon(d3);
        }
        else if(dadu2==4){
            Dice2.setIcon(d4);
        }
        else if(dadu2==5){
            Dice2.setIcon(d5);
        }
        else if(dadu2==6){
            Dice2.setIcon(d6);
        }

    }

}