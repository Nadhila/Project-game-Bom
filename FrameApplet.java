
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class FrameApplet extends JApplet 
{  
    private JLabel waktu = new JLabel("02:00");
    private Thread processTime;
    //private static JFrame jf = new JFrame("AYO TEMUKAN BOM SEGERA!");
    public JLabel hi =new JLabel();
    Font font = new Font("Felix Titling", Font.BOLD, 12);
    Font font1 = new Font("Arial", Font.BOLD, 13);
    ImageIcon background1 = new ImageIcon("petaa.png");
    JLabel bg1 = new JLabel(background1);

    ImageIcon sol = new ImageIcon("soldierr.png");
    JLabel chard =new JLabel(sol);
    JLabel charg =new JLabel();

    // deklarasi komponen
    private JButton bleft = new JButton("west");
    private JButton bright = new JButton("east");
    private JButton bup = new JButton("north");
    private JButton bdown = new JButton("south");
    private JButton benter = new JButton("enter");
    private JButton bulang = new JButton("Restart");

    private JTextArea keterangan = new JTextArea();

    // panggil class game
    private Game game = new Game();
    private String player ;
    private int icon,i,x,y,x1,y1;
    private Timer tunda;

    private JLabel iconP= new JLabel();
    String empty ="Tidak ada jalan";

    public void init(){
        komponenVisual();
        FrameApplet();
        actionPerformed();

        //Pilihplayer();
        // ActionListener();   
        //makeRoom();
        //sound.start();    
    }

    public void start()
    {
        setFocusable(true);
        //setFocusTraversalKeysEnabled(true);
        //addActionListener(this);
        setVisible(true);
        requestFocusInWindow();
    }

    public void FrameApplet() {
        time t = new time(2,"minutes",waktu);
        processTime = new Thread(t);
        processTime.start();
        if(true){
            Thread sound = new Thread() {
                    public void run() {
                        PutarSuara.playSound("suara/sounds2.wav");
                    }
                };
            sound.start();
        } 
        

    }

    public void komponenVisual(){

        JPanel panel = (JPanel)getContentPane();
        panel.setSize(600,600);    
        panel.setLayout(null);
        panel.setBackground(new Color(105,105,105));
        hi.setBounds(40, 0, 300, 30);
        hi.setText("HI Selamat Datang di kota Faraway");
        hi.setFont(font);        
        panel.add(hi);

        panel.add(waktu);
        waktu.setFont(font);
        waktu.setBounds(100,100,100,30);
        waktu.setForeground(Color.RED);

        chard.setBounds(187,272,20,20);
        panel.add(chard);

        iconP.setBounds(435,200,70,140);
        panel.add(iconP);

        bup.setBounds(100,465,90,20);
        bup.setBackground(new Color(100,149,237));
        bup.setFont(font1);

        bright.setBounds(185,500,90,20);
        bright.setBackground(new Color(100,149,237));
        bright.setFont(font1);

        bdown.setBounds(100,535,90,20);
        bdown.setBackground(new Color(100,149,237));
        bdown.setFont(font1);

        bleft.setBounds(15,500,90,20);
        bleft.setBackground(new Color(100,149,237));
        bleft.setFont(font1);

        bulang.setBounds(490, 465, 80, 20);
        bulang.setBackground(new Color(100,149,237));

        JScrollPane scrollPane = new JScrollPane(keterangan);
        scrollPane.setBounds(20,360,555,80);
        panel.add(scrollPane);

        // tambah komponen
        panel.setLayout(null);
        panel.add(bleft);
        panel.add(bright);
        panel.add(bup);
        panel.add(bdown);
        panel.add(benter);
        panel.add(bulang);

        panel.add(bg1);
        bg1.setBounds(10,30,550,320);
    }

    public void Pilihplayer(){
        ImageIcon P1 = new ImageIcon("P1.png");
        ImageIcon P2 = new ImageIcon("PP2.png");
        ImageIcon P3 = new ImageIcon("PP3.png");
        ImageIcon P4 = new ImageIcon("PP4.png");
        if(icon==1){
            iconP.setIcon(P1);
        }

        else if(icon==2){
            iconP.setIcon(P2);
        }

        else if(icon==3){
            iconP.setIcon(P3);
        }
        else if(icon==4){
            iconP.setIcon(P4);
        }
    }

    public void actionPerformed(){
        //String e = ae.getActionCommand();

        x=0;
        y=0;
        x1 = chard.getX();
        y1 = chard.getY();

        bleft.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  

                    keterangan.setText(game.Go("west"));
                    String letak =keterangan.getText();
                    if(letak.compareTo(empty)!=0){
                        x-=27;
                        y-=29;
                        chard.setBounds(x1+x,y1+y,32,32);

                    }
                    if(game.adaBom()) {

                        // panggil class bom jika bom telah ditemukan 
                        new Bom();

                    }
                    kondisi();
                }
            });
        bright.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                    keterangan.setText(game.Go("east"));
                    String letak =keterangan.getText();
                    if(letak.compareTo(empty)!=0){
                        x+=27;
                        y+=26;
                        chard.setBounds(x1+x,y1+y,32,32);

                    }
                    if(game.adaBom()) {

                        // panggil class bom jika bom telah ditemukan 
                        new Bom();

                    }
                    kondisi();
                }
            });
        bdown.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                    keterangan.setText(game.Go("south"));
                    String letak =keterangan.getText();
                    if(letak.compareTo(empty)!=0){
                        x-=30;
                        y+=29;
                        chard.setBounds(x1+x,y1+y,32,32);
                    }
                    if(game.adaBom()) {

                        // panggil class bom jika bom telah ditemukan 
                        new Bom();

                    }
                    kondisi();
                }
            });

        bup.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                    keterangan.setText(game.Go("north"));
                    String letak =keterangan.getText();
                    if(letak.compareTo(empty)!=0){
                        x+=30;
                        y-=29;
                        chard.setBounds(x1+x,y1+y,32,32);
                    }
                    if(game.adaBom()) {

                        // panggil class bom jika bom telah ditemukan 
                        new Bom();

                    }
                    kondisi();
                }
            });

        bulang.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                    keterangan.setText("Anda mengulangi permainan...\n");
                    processTime.interrupt();
                    time l = new time(2,"minutes",waktu);
                    processTime = new Thread(l);
                    processTime.start();
                    chard.setBounds(187,272,20,20);
                    game = new Game();
                    Thread sound2 = new Thread() {
                            public void run() {
                                for(i=0;i<3000;++i){
                                    PutarSuara.playSound("suara/sounds2.wav");
                                }
                            }
                        };
                    sound2.start();  
                }
            });

    }

    public void kondisi(){

        if(game.adaMusuh()) {

            int pertanyaan =(int) (Math.random()*6+1);
            if(pertanyaan==1){
                String message = JOptionPane.showInputDialog(this, String.format("Jawab dengan segeraa!!.\nPertanyaan :\n"
                            + "Uang kalau di Lempar jadi apa?"), "Ada musuh!!!", JOptionPane.WARNING_MESSAGE);
                String jawaban = message;

                if(jawaban.equals("rebutan") ) {
                    JOptionPane.showMessageDialog(this, "Selamat, anda berhasil lolos dari musuh!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);

                    game.setTidakAdaMusuh();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Maaf, jawaban Anda Salah!\nAnda diculik oleh terorist!", "Salah!!", JOptionPane.ERROR_MESSAGE);
                    game.backToEntranceStartRoom();
                    chard.setBounds(187,272,20,20);
                    game = new Game();
                }
            }

            else if (pertanyaan==6){
                String message = JOptionPane.showInputDialog(this, String.format("Jawab dengan segeraa!!.\nPertanyaan :\n"
                            + "Jauh dimata dekat di hati ?"), "Ada musuh!!!", JOptionPane.WARNING_MESSAGE);
                String jawaban = message;

                if(jawaban.equals("usus") ) {
                    JOptionPane.showMessageDialog(this, "Selamat, anda berhasil lolos dari musuh!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);

                    game.setTidakAdaMusuh();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Maaf, jawaban Anda Salah!\nAnda diculik oleh terorist!", "Salah!!", JOptionPane.ERROR_MESSAGE);
                    game.backToEntranceStartRoom();
                    chard.setBounds(187,272,20,20);
                    game = new Game();
                }
            }
            else if(pertanyaan==3){
                String message = JOptionPane.showInputDialog(this, String.format("Jawab dengan segeraa!!.\nPertanyaan :\n"
                            + "Berapa banyak volume tanah pada lubang didalam lubang dengan panjang 3 meter,lebar 2 meter dan kedalaman 1meter?"), "Ada musuh!!!", JOptionPane.WARNING_MESSAGE);
                String jawaban = message;

                if(jawaban.equals("kosong") ) {
                    JOptionPane.showMessageDialog(this, "Selamat, anda berhasil lolos dari musuh!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);

                    game.setTidakAdaMusuh();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Maaf, jawaban Anda Salah!\nAnda diculik oleh terorist!", "Salah!!", JOptionPane.ERROR_MESSAGE);
                    game.backToEntranceStartRoom();
                    chard.setBounds(187,272,20,20);
                    game = new Game();
                }
            }
            else if(pertanyaan==4){
                String message = JOptionPane.showInputDialog(this, String.format("Jawab dengan segeraa!!.\nPertanyaan :\n"
                            + "Ibu Andi memiliki 3 orang anak, yang pertama adi, kedua rudi, siapakah yang ke 3??"), "Ada musuh!!!", JOptionPane.WARNING_MESSAGE);
                String jawaban = message;

                if(jawaban.equals("andi") ) {
                    JOptionPane.showMessageDialog(this, "Selamat, anda berhasil lolos dari musuh!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);

                    game.setTidakAdaMusuh();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Maaf, jawaban Anda Salah!\nAnda diculik oleh terorist!", "Salah!!", JOptionPane.ERROR_MESSAGE);
                    game.backToEntranceStartRoom();
                    chard.setBounds(187,272,20,20);
                    game = new Game();
                }
            }
             else if(pertanyaan==5){
               new dadu();
            }
            else if(pertanyaan==2){
               new dadu();
            }
        }

        if(game.adakode()) {
            JOptionPane.showMessageDialog(this,"Anda Mendapatkan kode yaitu 225","Image OptionPane",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("kalah1.gif"));
            game.ambilkode();
        }
    }

}

