package schoolTest;
import java.util.*;
public class t9_4_2 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            boolean flag = true;
            for (int i=0;i<s.length();i++){
                if(s.charAt(i)<48||(s.charAt(i)>57&&s.charAt(i)<65)||s.charAt(i)>70){
                    flag = false;
                }
            }
            if(!flag){
                throw new MyException("不是十六进制数");
            }
            double sum = 0,m;
            int n=0;
            String str;
            for (int i=0;i<s.length();i++){
                if(s.charAt(i)>=48&&s.charAt(i)<=57){
                    str = String.valueOf(s.charAt(i));
                    n = Integer.parseInt(str);
                    m = n*Math.pow(16,s.length()-i-1);
                    sum += m;
                }
                if(s.charAt(i)>=65&&s.charAt(i)<=70){
                    n = s.charAt(i) - 55;
                    m = n*Math.pow(16,s.length()-i-1);
                    sum += m;
                }
            }
            System.out.println(sum);
        }catch (MyException e){
            System.out.println(e);
        }
    }
}
class MyException extends Exception{
    String id;
    public MyException(String str){
        id = str;
    }
    public String toString(){
        return ("异常："+id);
    }
}
