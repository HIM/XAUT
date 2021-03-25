package TCP;

import TCP.domain.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TalkServer {
    public static ArrayList<Client> allclient= new ArrayList<Client>();

    public static int clientnum = 0;

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(5432);
            while (true){
                Socket s1 = s.accept();
                DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
                DataInputStream din = new DataInputStream(s1.getInputStream());

                Client x = new Client(clientnum, dos, din);
                allclient.add(x);
                x.start();
                clientnum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
