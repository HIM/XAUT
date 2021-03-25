package TCP.domain;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;

public class receiveThread extends Thread{
    DataInputStream dis;

    public receiveThread(DataInputStream dis){
        this.dis = dis;
        this.start();
    }

    public void run(){
        for(;;){
            try{
                String str = dis.readUTF();
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
