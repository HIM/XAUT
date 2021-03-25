package schoolTest;
import java.io.*;
public class t13_3_4 {
    public static void main(String[] args) throws IOException{
        //task.txt : HelloWorld Typora OneNote XMind
        FileReader fr = new FileReader("src/schoolTest/input/task.txt");
        char[] cbuf = new char[1024];
        int len = 0;
        StringBuilder builder = new StringBuilder();
        while ((len=fr.read(cbuf))!=-1){
            builder.append(cbuf,0,len);
        }

        String s = new String(builder);
        String[] sArray = s.split(" ");
        System.out.println("有"+sArray.length +"个单词");
    }
}
