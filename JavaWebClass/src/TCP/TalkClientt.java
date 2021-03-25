package TCP;

import TCP.domain.receiveThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TalkClientt {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Socket s1 = new Socket("localhost",5432);
        DataInputStream dis = new DataInputStream(s1.getInputStream());//获取输入进来的输入流
        final DataOutputStream dos = new DataOutputStream(s1.getOutputStream());

        new receiveThread(dis);
        for(;;){
            dos.writeUTF("张三：" + in.nextLine());
        }

    }
}
