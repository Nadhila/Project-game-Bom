 

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame  { 
    private static JFrame frame_dasar;
    private static JFrame frame_play;
    private static JFrame frame_cerita;

    //aksesoris frame dasar
    JButton play = new JButton("Play");
    JButton exit = new JButton ("Exit");
    ImageIcon background = new ImageIcon("background.png");
    JLabel bg = new JLabel(background);

    //aksesoris frame play
    JLabel pilih = new JLabel();
    JLabel karakter = new JLabel();

    JRadioButton p1 = new JRadioButton();
    JRadioButton p2 = new JRadioButton();
    JRadioButton p3 = new JRadioButton();
    JRadioButton p4 = new JRadioButton();
    ButtonGroup kelompok = new ButtonGroup();
    JButton Ready = new JButton();

    Font font = new Font("Felix Titling", Font.BOLD, 15);
    JTextField nama = new JTextField();
    int pilihan1;
    String player1;

    //aksesoris frame cerita
    JButton play1 = new JButton ("Play");
    JButton bt1 = new JButton ("Next");
    //JLabel keterangan1 = new JLabel();
    ImageIcon background1 = new ImageIcon("bomsquad.png");
    JLabel bg1 = new JLabel(background1);
    JTextArea sinopsis = new JTextArea(" ");
    JScrollPane scrollpane = new JScrollPane(sinopsis);

    JPanel panel, panel1, panel2, panel3;
    ImageIcon P1 = new ImageIcon("P1.png");
    ImageIcon P2 = new ImageIcon("PP2.png");
    ImageIcon P3 = new ImageIcon("PP3.png");
    ImageIcon P4 = new ImageIcon("PP4.png");
    
    public Frame(){
         if(true){
            Thread sound = new Thread() {
                    public void run() {
                        PutarSuara.playSound("suara/sounds1.wav");
                    }
                };
            sound.start();
        } 

        
        makeFrame_dasar();
        frame_dasar.setVisible(true);
        frame_dasar.setLocationRelativeTo(null);
        makeFrame_play();
        frame_play.setVisible(false);
        frame_play.setLocationRelativeTo(null);
        makeFrame_cerita();
        frame_cerita.setVisible(false);
        frame_cerita.setLocationRelativeTo(null);
        frame_dasar.setIconImage(Toolkit.getDefaultToolkit().getImage("bsRemoteIcon.png"));
        frame_play.setIconImage(Toolkit.getDefaultToolkit().getImage("bsRemoteIcon.png"));
        frame_cerita.setIconImage(Toolkit.getDefaultToolkit().getImage("bsRemoteIcon.png"));
    }
    
    public static void main(String[] args) 
    {
        new Frame();
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
            }
        }

    }

    public void makeFrame_dasar()
    {
        frame_dasar= new JFrame("\t\t=====BOM SQUAD=====");
        frame_dasar.setSize(750,550);
        frame_dasar.setResizable(false);
        komponenVisual_dasar();
        FrameDasar();
    }

    public void makeFrame_play(){
        frame_play = new JFrame("\t\t=====BOM SQUAD=====");
        frame_play.setSize(750,550);
        frame_play.setResizable(false);
        komponenVisual_play();
        selectPlayer();
    }

    public void makeFrame_cerita()
    {
        frame_cerita= new JFrame("\t\t=====BOM SQUAD=====");
        frame_cerita.setSize(750,550);
        frame_cerita.setVisible(false);
        sinopsis.setEditable(false);
        komponenVisual_cerita(); 
        FrameCerita();
    }

    public void komponenVisual_dasar(){
        panel2 = (JPanel)frame_dasar.getContentPane();
        panel2.setLayout(null);

        panel2.add(play);
        play.setBounds(620,400,100,40);
        play.setBackground(new Color(100,149,237));

        panel2.add(exit);
        exit.setBounds(620,460,100,40);
        exit.setBackground(new Color(100,149,237));

        panel2.add(bg);
        bg.setSize(750,550);

    }

    public void komponenVisual_play(){
        JPanel panel =(JPanel)frame_play.getContentPane();
        panel.setLayout(null);
        panel.setBackground(new Color(105,105,105));

        ImageIcon P1 = new ImageIcon("P1.png");
        JLabel char1 =new JLabel(P1);
        panel.add(char1);
        char1.setBounds(100,200,70,140);
        p1.setBounds(110,360,20,20);
        panel.add(p1);

        ImageIcon P2 = new ImageIcon("PP2.png");
        JLabel char2 =new JLabel(P2);
        panel.add(char2);
        char2.setBounds(260,200,70,140);
        p2.setBounds(280,360,20,20);
        panel.add(p2);

        ImageIcon P3 = new ImageIcon("PP3.png");
        JLabel char3 =new JLabel(P3);
        panel.add(char3);
        char3.setBounds(420,200,70,140);
        p3.setBounds(440,360,20,20);
        panel.add(p3);

        ImageIcon P4 = new ImageIcon("PP4.png");
        JLabel char4 =new JLabel(P4);
        panel.add(char4);
        char4.setBounds(580,200,70,140);
        p4.setBounds(590,360,20,20);
        panel.add(p4);

        kelompok.add(p3);
        kelompok.add(p4);

        kelompok.add(p1);
        kelompok.add(p2);

        karakter.setBounds(270,130,300,50);
        karakter.setText("PILIH CHARACTER KAMU");
        karakter.setFont(font);
        panel.add(karakter);

        pilih.setBounds(310,0,200,50);
        pilih.setText("NAMA PLAYER");
        pilih.setFont(font);
        panel.add(pilih);

        nama.setBounds(310,50,110,30);
        panel.add(nama);

        panel.add(Ready);
        Ready.setBounds(320,450,100,30);
        Ready.setBackground(new Color(100,149,237));
        Ready.setText("READY");
    }

    public void komponenVisual_cerita(){
        panel1 = (JPanel)frame_cerita.getContentPane();
        panel1.setLayout(null);

        panel1.add(play1);
        play1.setBounds(650,460,70,30);
        play1.setBackground(new Color(100,149,237));
        
        panel1.add(scrollpane);
        scrollpane.setBounds(0,290,750,300);

        panel1.add(bg1);
        bg1.setSize(750,290);

    }

    public void FrameDasar()
    {
        play.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    makeFrame_play();
                    frame_play.setVisible(true);
                    frame_dasar.setVisible(false);
                }
            }
        ); 

        exit.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            }
        );

    }

    public void pilihPlayer(){
        

        if(p1.isSelected()==true){
            pilihan1=1;
        }

        else if(p2.isSelected()==true){
            pilihan1=2;
        }

        else if (p3.isSelected()==true){
            pilihan1=3;
        }
        else if(p4.isSelected()==true){
            pilihan1=4;
        }
    }

    public void selectPlayer(){
        Ready.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    
                    
         
                    frame_cerita.setVisible(true);

                    frame_play.setVisible(false);
                }
            }
        );
    }

    public void FrameCerita()
    {
         sinopsis.append("\nSebuah kota didatangi teroris yang telah meletakkan bom dipenjuru kota dengan tujuan untuk menghancurkan kota.\n");
         sinopsis.append("Bom tersebut akan meledak jika tidak segera dijinakkan. Hal ini membuat seluruh masyarakat\n");
         sinopsis.append("kota ketakutan karna kota akan hancur porak poranda.\n\n");
         sinopsis.append("Ayo penjinak bom, segera selamatkan kota  sebelum terlambat!!!!!!\n\n");
         sinopsis.append("Bom diletakkan di sebuah koper di empat daerah yang telah acak, untuk dapat membuka koper yang berisi bom si \n");
         sinopsis.append("penjinakkan bom harus terlebih dahulu mendapatkan koper di daerah yang juga telah diacak. Beberapa daerah\n");
         sinopsis.append("terdapat musuh untuk dapat mengalahkannya harus dapat menjawab pertanyaan yang ia berikan.\n");
         
         play1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    String name = nama.getText();
                    pilihPlayer();
                    new MainFrame(name,pilihan1);
                    frame_cerita.setVisible(false);
                    frame_dasar.setVisible(false);
        
                   
                }
            }
        ); 

    }
}