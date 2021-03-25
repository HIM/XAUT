package TCP.domain;

import TCP.TalkServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Client extends Thread{
    int id;
    DataOutputStream dos;
    DataInputStream din;

    public Client(int id, DataOutputStream dos, DataInputStream dis){
        this.id = id;
        this.dos = dos;
        this.din = dis;
    }

    public void run(){
        while (true){
            try {
                String message = din.readUTF();
                for(int i=0; i< TalkServer.clientnum; i++){
                    if(i != id){
                        TalkServer.allclient.get(i).dos.writeUTF(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
