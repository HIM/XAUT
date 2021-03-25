package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Rec {

    public static void recive() {
        Scanner input = new Scanner(System.in);
        // ���ն�
        try {
            //�������շ����׽��� ����  ����send������DatagramPacket��ip��ַ��˿ں�һ��
            DatagramSocket socket = new DatagramSocket(9001, InetAddress.getByName("localhost"));
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);   //�����������ݰ�

            for(;;){
                //���ղ���
                socket.receive(packet);
                byte data[] = packet.getData();// ���յ�����
                InetAddress address = packet.getAddress();// ���յĵ�ַ
                System.out.println("�յ���" + new String(data));

                String temp = input.nextLine();     // ���ظ�������
                byte buffer[] = temp.getBytes();
                //�������ݱ���ָ�����͸� �����ߵ�socketaddress��ַ
                DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length, packet.getSocketAddress());
                socket.send(packet2);//����
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