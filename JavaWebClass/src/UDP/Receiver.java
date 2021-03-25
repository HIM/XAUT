package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Receiver {

    public static void recive() {
        Scanner input = new Scanner(System.in);
        // 接收端
        try {
            //创建接收方的套接字 对象  并与send方法中DatagramPacket的ip地址与端口号一致
            DatagramSocket socket = new DatagramSocket(9001, InetAddress.getByName("localhost"));
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);   //创建接收数据包

            for(;;){
                //接收操作
                socket.receive(packet);
                byte data[] = packet.getData();// 接收的数据
                InetAddress address = packet.getAddress();// 接收的地址
                System.out.println("收到：" + new String(data));

                String temp = input.nextLine();     // 返回给发送者
                byte buffer[] = temp.getBytes();
                //创建数据报，指定发送给 发送者的socketaddress地址
                DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length, packet.getSocketAddress());
                socket.send(packet2);//发送
            }

//            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        recive();
    }
}