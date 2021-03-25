package schoolTest;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class t12_3_4 extends Frame implements Runnable{
    TextArea disp = new TextArea(10,50);
    int pos;
    boolean flag;
    Button onoff;

    public static void main(String[] args) {
        new t12_3_4();
    }

    public t12_3_4(){
        add("Center",disp);
        onoff = new Button("End");
        add("South",onoff);
        new Thread(t12_3_4.this).start();
        new Thread(t12_3_4.this).start();
        new Thread(t12_3_4.this).start();
        new Thread(t12_3_4.this).start();
        new Thread(t12_3_4.this).start();
        new Thread(t12_3_4.this).start();

        onoff.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getActionCommand().equals("end")){
                    flag = false;
                }
            }
        });
        setSize(300,200);
        setVisible(true);
    }

    public void run(){
        while (flag){
            Thread th = Thread.currentThread();
            pos = (int)(Math.random()*10);
            String message = pos+"\n";
            disp.setText(message);
        }
    }
}
