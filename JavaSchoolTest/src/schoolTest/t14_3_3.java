package schoolTest;
import java.util.*;
public class t14_3_3 {
    public static void main(String[] args) {
        Map<String,String> stu = new HashMap<String,String>();
        stu.put("301","XiaoAi");
        stu.put("304","Siri");
        stu.put("302","Yoyo");
        int k=0 , n=0 , j;
        String str;
        Scanner in = new Scanner(System.in);
        int[] s = new int[stu.size()];
        while(k==0){
            System.out.println("根据学号查找学生姓名请输入1，按学号顺序输出所有学生请输入2");
            n = in.nextInt();
            switch (n){
                case 1:
                    System.out.println("请输入学号：");
                    str = in.next();
                    System.out.println(stu.get(str));
                    System.out.println("继续，输入0；退出，输入1");
                    k = in.nextInt();
                    break;
                case 2:
                    j=0;
                    for (String  key:stu.keySet()) {
                        s[j] = Integer.parseInt(key);
                        System.out.println(key);
                        j++;
                    }
                    Arrays.sort(s);
                    System.out.println(s);
                    System.out.println("继续，输入0；退出，输入1");
                    k = in.nextInt();
                    break;
            }
        }
    }
}
