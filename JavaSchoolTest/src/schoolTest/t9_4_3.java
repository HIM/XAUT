package schoolTest;
import java.util.*;
public class t9_4_3 {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            String[] str = s.split("/");
            if(str.length!=3){
                throw new MyExceptionn("格式异常");
            }
            int y = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int d = Integer.parseInt(str[2]);
            if(y<0){
                throw new MyExceptionn("年份错误");
            }
            if(m<1||m>12){
                throw new MyExceptionn("月份错误");
            }
            int[] dayArr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
            if(y%400==0||(y%4==0&&y%100!=0)) {
                dayArr[2] += 1;
            }
            if(d<1||d>dayArr[m]){
                throw new MyExceptionn("日期错误");
            }
            Date date = new Date(y,m,d);
            System.out.println(date);
        }catch (MyExceptionn e){
            System.out.println(e);
        }
    }
}
class Date{
    int year;
    int month;
    int day;
    Date(int y,int m,int d){
       year = y;
       month = m;
       day = d;
    }
    public String toString() {
        return year+"/"+month+"/"+day;
    }
}
class MyExceptionn extends Exception{
    String id;
    public MyExceptionn(String str){
        id = str;
    }
    public String toString(){
        return ("异常："+id);
    }
}