import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
public class Bom{
    public JFrame framebom,framekoper;
    JButton jawab = new JButton();
    JLabel ask = new JLabel();
    Font font = new Font("Verdana", Font.BOLD, 15);
    private Game game = new Game();

    JTextField kode = new JTextField();
    JButton ok = new JButton("ok");

    JPanel Panel, Panel1; 
    private int i;

    public Bom()
    {
        makeFrame();
        framekoper.setVisible(true);
        framekoper.setLocationRelativeTo(null);

        makeFrame1();
        framebom.setVisible(false);
        framebom.setLocationRelativeTo(null);

    }

    public void setVisible(boolean visible)
    {
        framebom.setVisible(visible);
        framekoper.setVisible(visible);
    }

    public void makeFrame(){
        framekoper = new JFrame("BOM SQUAD");
        framekoper.setSize(300,300);
        komponenVisual1();
        koper();
    }

    public void makeFrame1(){
        framebom = new JFrame("BOM SQUAD");
        framebom.setSize(500,500);
        komponenVisual();
        jawaban();

    }
    //method tampilan pada frame
    private void komponenVisual1(){
        JPanel panel1 = (JPanel)framekoper.getContentPane();
        panel1.setLayout(null);
        panel1.setBackground(new Color(105,105,105));

        panel1.add(kode);
        kode.setBounds(105,190,80,25);

        panel1.add(ok);
        ok.setBounds(120,230,50,20); 
        
        ImageIcon kpr = new ImageIcon("koper.png");
        JLabel gambar =new JLabel(kpr);
        gambar.setBounds(65,30,150,150);
        panel1.add(gambar);
    }

    private void komponenVisual(){
        JPanel panel = (JPanel)framebom.getContentPane();
        panel.setLayout(null);
        panel.setBackground(new Color(105,105,105));

        jawab.setBackground(SystemColor.white);
        jawab.setBounds(new Rectangle(21,360, 150, 20));
        jawab.setFont(font);
        jawab.setEnabled(true);
        jawab.setText("PILIH KABEL");
        panel.add(jawab);

        ImageIcon P4 = new ImageIcon("kabel.png");
        JLabel kabel =new JLabel(P4);
        kabel.setBounds(5,5,475,350);
        panel.add(kabel);

    }
    public void koper(){
        ok.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    i++;
                    String code= kode.getText();
                    if(i<=3){
                    if(code.equals("225")){
                       framebom.setVisible(true); 
                       framekoper.setVisible(false);
                       //framekoper.setBackground(new 
                    }
                    else{
                         JOptionPane.showMessageDialog(null, "KODE yang anda masukkan salah","COBA LAGI!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "GAME OVER!!!!","COBA LAGI!!", JOptionPane.ERROR_MESSAGE);
                    game = new Game();
                    framekoper.setVisible(false);
                }
                }
            } );
    }

    public void jawaban(){
        jawab.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String message = JOptionPane.showInputDialog(null, String.format("Pilih kabel yang akan dipotong! :\n"), "cepaaat!!!", JOptionPane.WARNING_MESSAGE);
                    String answer = message;

                    if(answer.equals("pink") ) {
                        JOptionPane.showMessageDialog(null, "Selamat, Anda berhasil menjinakkan bom!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("bombman.png"));
                        framebom.setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Kabel yang anda potong salah!!!\nBom meledak dan menghancurkan seluruh kota!", "Salah!!", JOptionPane.ERROR_MESSAGE,new ImageIcon("bye3.gif"));
                        framebom.setVisible(false);
                         game = new Game();
                    }

                }
            });
    }

}
