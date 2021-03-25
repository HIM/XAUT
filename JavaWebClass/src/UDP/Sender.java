package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Sender {

    public static void send() {
        Scanner input = new Scanner(System.in);
        // 发送端
        try {
            DatagramSocket socket = new DatagramSocket(9004);// 创建发送方

            for(;;){
                String text = input.nextLine(); // 发送的内容
                byte[] buf = text.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 9001);   // 构造数据报包
                socket.send(packet);
                displayReciveInfo(socket);
            }

//            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 接收数据并打印出来
     *
     * @param socket
     * @throws IOException
     */
    public static void displayReciveInfo(DatagramSocket socket)
            throws IOException {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        byte data[] = packet.getData();// 接收的数据
        InetAddress address = packet.getAddress();// 接收的地址
        System.out.println("接收的文本:::" + new String(data));
    }

    public static void main(String[] args) {
        send();
    }
}