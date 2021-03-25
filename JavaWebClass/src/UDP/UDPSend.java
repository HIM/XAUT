package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPSend {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte[] message = new byte[2048];
        DatagramSocket datagramSocketrec = null;
        try {
            datagramSocketrec = new DatagramSocket(5433); //收
        } catch (SocketException e) {
            e.printStackTrace();
        }
        for(;;){
            String str = input.nextLine();
            message = str.getBytes();

            try {
                //发
                InetAddress address = InetAddress.getByName("localhost");
                DatagramPacket packetsend = new DatagramPacket(message, message.length, address, 5432);//发
                DatagramSocket datagramSocket = new DatagramSocket();
                datagramSocket.send(packetsend);
                datagramSocket.close();

                //收
                byte[] buffer = new byte[2048];
                DatagramPacket packetrec = new DatagramPacket(buffer, buffer.length);//收
                datagramSocketrec.receive(packetrec);
                String msg = new String(buffer, 0, packetrec.getLength());
                System.out.println("收到: "+msg);

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
