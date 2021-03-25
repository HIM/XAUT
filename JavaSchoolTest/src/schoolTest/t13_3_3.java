package schoolTest;
import java.io.*;
import java.util.Scanner;
public class t13_3_3 {
    public static void main(String[] args)  throws IOException{
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String s = "src/schoolTest/input/" + str + ".txt";
        FileReader fr = new FileReader(s);
        char[] cbuf = new char[1024];
        int len = 0;
        StringBuilder builder = new StringBuilder();
        while ((len=fr.read(cbuf))!=-1){
            builder.append(cbuf,0,len);
        }
        System.out.println(builder);
    }
}
