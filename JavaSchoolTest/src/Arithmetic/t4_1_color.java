package Arithmetic;
import java.util.*;
public class t4_1_color {
    static int k;
    static int n;
    static int m;
    static int[][] map;
    static int[] colors;

    static void backTracking(int t){
        if(t>n) {
            for(int h=1;h<=n;h++) {
                System.out.print(colors[h]+" ");
            }
            System.out.println();
        }
        else{
            for(int i=1;i<=k;i++){      //遍历颜色
                if(check(t,i)==1){
                    colors[t] = i;
                    backTracking(t+1);
                }
            }
        }
    }
    static int check(int t,int i){
        for(int k=1;k<t;k++){
            if(map[t][k]==1&&colors[k]==i)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入点数，边数，颜色数：");
        n = in.nextInt();   //n是点数
        m = in.nextInt();   //m是边数
        k = in.nextInt();   //k是颜色数
        map = new int[n+1][n+1];
        System.out.println("请输入每条边所对应的两点：");
        for(int i=1;i<=m;i++){      //该循环输入边数
            int x = in.nextInt();
            int y = in.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }

        colors = new int[k+1];
        for(int i=1;i<=k;i++){
            colors[i] = 0;
        }
        backTracking(1);
        //5 8 4
        //1 2
        //1 3
        //1 4
        //2 3
        //2 4
        //2 5
        //3 4
        //4 5
    }
}
