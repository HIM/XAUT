package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPReceive {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte[] message = new byte[2048];//发
        try {
            //收
            DatagramSocket datagramSocketrec = new DatagramSocket(5432);
            byte[] buffer = new byte[2048];
            DatagramPacket packetrec = new DatagramPacket(buffer, buffer.length);//收

            for(;;){
                //收
                datagramSocketrec.receive(packetrec);
                String msg = new String(buffer, 0, packetrec.getLength());
                System.out.println("收到: "+msg);
                //发
                String str = input.next();
                message = str.getBytes();

                InetAddress address = InetAddress.getByName("localhost");
                DatagramPacket packetsend = new DatagramPacket(message, message.length, address, 5433);//发
                DatagramSocket datagramSocketsend = new DatagramSocket();
                datagramSocketsend.send(packetsend);
                datagramSocketsend.close();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
