package schoolTest;
import java.util.Scanner;
public class t7_3_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuffer str = new StringBuffer();  //空对象
        while(true){
            String str1 = input.next();
            if(str1.equals("end")){
                break;
            }
            str.append(str1);
        }       //全部接收
        int n1 = 0;
        for(int i=0;i<str.length();i++){
            char x = str.charAt(i);
            if((x>='a'&&x<='z')||(x>='A'&&x<='Z')){
                n1++;
            }

        }
        System.out.println("原文："+str.toString());
        System.out.println("1.英文字母个数是："+n1);
        for(int i=0;i<str.length();i++){
            char x = str.charAt(i);
            if(x=='t'&&i<str.length()-2){
                char x1 = str.charAt(i+1);
                if(x1=='h'){
                    char x2 = str.charAt(i+2);
                    if(x2=='e'){
                        str.deleteCharAt(i+2);
                        str.deleteCharAt(i+1);
                        str.setCharAt(i,'a');
                    }
                }
            }
        }
        System.out.println("2.the全部改为a后："+str.toString());
        System.out.print("3.数字串：");
        for(int i=0;i<str.length();i++){
            char x = str.charAt(i);
            if(x>='0'&&x<='9'){
                System.out.print(x);
            }

        }
    }
}
