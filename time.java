import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class time implements Runnable{
    private int minutes;
    private int second;
    private JLabel Ltime; 

    /**
     *method constuctor
     */
    public time(int i, String waktu, JLabel Ltime){
        if(waktu.equals("minutes")){
            if(i>0)
                minutes = i-1;
            second = 60;
        }else{
            second=i;
            minutes=0;
        }        
        this.Ltime = Ltime;
    }
    
    public void run(){
        try{
            while(minutes>0 || second>0){
                Thread.sleep(1000);
                if(minutes!=0 && second==1){
                    second=60;
                    minutes--;
                }else if(second!=0){
                    second--;
                }

                if(second<10)
                    Ltime.setText("0"+minutes+" : 0"+second);
                else
                    Ltime.setText("0"+minutes+" : "+second);
            }

            if(minutes == 0 && second == 0){
              JOptionPane.showMessageDialog(null,"Time Out, GAME OVER!!!");
            }
        }catch(InterruptedException e){}
    }
}