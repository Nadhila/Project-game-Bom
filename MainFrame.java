
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class MainFrame extends JPanel implements ActionListener
{  
    private JLabel waktu = new JLabel("02:00");
    private Thread processTime;
    private static JFrame jf = new JFrame("AYO TEMUKAN BOM SEGERA!");
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
    private JButton bquit = new JButton("Quit");

    private JTextArea keterangan = new JTextArea();

    // panggil class game
    private Game game = new Game();
    private String player ;
    private int icon,i,x,y,x1,y1;
    private Timer tunda;

    private JLabel iconP= new JLabel();
    public MainFrame(String name,int pilihan) {
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
        player = name;
        icon=pilihan;
        jf.setVisible(true);
        jf.setSize(600, 600);
        jf.setLocationRelativeTo(null);
        komponenVisual();
        Pilihplayer();
        keterangan.setBounds(120, 108, 550, 320);
        keterangan.setEditable(false);
        keterangan.setText(game.printWelcome());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setFocusable(true);
        jf.setFocusTraversalKeysEnabled(true);
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage("bsRemoteIcon.png"));
        // action listener untuk komponen
        bleft.addActionListener(this);
        bright.addActionListener(this);
        bup.addActionListener(this);
        bdown.addActionListener(this);
        benter.addActionListener(this);
        bulang.addActionListener(this);
        bquit.addActionListener(this);

    }

    public void komponenVisual(){

        JPanel panel = (JPanel)jf.getContentPane();
        panel.setLayout(null);
        panel.setBackground(new Color(105,105,105));
        hi.setBounds(40, 0, 300, 30);
        hi.setText("HI "+player+"  Selamat Datang di kota Faraway");
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
        bquit.setBounds(490, 500, 80, 20);
        bquit.setBackground(new Color(100,149,237));

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
        panel.add(bquit);
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        String e = ae.getActionCommand();
        x=0;
        y=0;
        x1 = chard.getX();
        y1 = chard.getY();
        String empty ="Tidak ada jalan";
        if(e.equals("west")) {
            keterangan.setText(game.Go("west"));
            String letak =keterangan.getText();
            if(letak.compareTo(empty)!=0){
                x-=27;
                y-=29;
                chard.setBounds(x1+x,y1+y,32,32);
            }                

        }
        else if(e.equals("east")) {
            keterangan.setText(game.Go("east"));
            String letak =keterangan.getText();
            if(letak.compareTo(empty)!=0){
                x+=27;
                y+=26;
                chard.setBounds(x1+x,y1+y,32,32);
            }           

        }
        else if(e.equals("south")) {
            keterangan.setText(game.Go("south"));
            String letak =keterangan.getText();
            if(letak.compareTo(empty)!=0){
                x-=30;
                y+=29;
                chard.setBounds(x1+x,y1+y,32,32);
            }

        }
        else if(e.equals("north")) {
            keterangan.setText(game.Go("north"));
            String letak =keterangan.getText();
            if(letak.compareTo(empty)!=0){
                x+=30;
                y-=29;
                chard.setBounds(x1+x,y1+y,32,32);
            }
        }

        else if(e.equals("Restart")) {
            keterangan.setText("Anda mengulangi permainan...\n");
            processTime.interrupt();
            time l = new time(2,"minutes",waktu);
            processTime = new Thread(l);
            processTime.start();
            chard.setBounds(187,272,20,20);
            game = new Game();
        }
        else if(e.equals("Quit")) {
            System.exit(0);
             processTime.interrupt();
        }

        if(game.adaBom()) {

            // panggil class bom jika bom telah ditemukan 
            new Bom();

        }

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
