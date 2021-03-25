package schoolTest;
import java.util.Scanner;
public class t9_4_1 {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);
            String n = input.nextLine();
            if(n.startsWith("0x")){
                String sub = n.substring(2);
                int x = Integer.parseInt(sub,16);
                int xi = JC(x);
                System.out.println(xi);
            }else{
                int index = Integer.parseInt(n);
                int out = JC(index);
                System.out.println(out);
            }
        }catch (NumberFormatException n){
            System.out.println("请输入整数");
        }

    }
    static int JC(int k){
        if(k==1)
            return 1;
        return k*JC(k-1);
    }
}
