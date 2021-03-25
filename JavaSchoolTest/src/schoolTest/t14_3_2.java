package schoolTest;
import java.util.*;
public class t14_3_2 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>();
        list.add(100.0);
        list.add(90.0);
        list.add(60.0);
        list.add(95.0);
        double sum = 0;
        double max = 0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
            if(list.get(i)>max)
                max = list.get(i);
        }
        sum = sum/list.size();
        System.out.println("平均分："+sum);
        System.out.println("最高分："+max);
    }
}
