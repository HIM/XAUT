package schoolTest;
import java.util.Scanner;
public class test {
    static int x,y,z;
    static int grh[][];
    static int colors[];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();//节点数
        y=sc.nextInt();//边数
        z=sc.nextInt();//颜色数
        grh=new int[x+1][x+1];
        colors=new int[x+1];//每个点着色
        for(int i=1;i<=x;i++) {
            colors[i]=0;
        }
        for(int i=1;i<=y;i++) {
            int start=sc.nextInt();
            int end=sc.nextInt();
            if(start!=end) {
                grh[start][end]=1;
                grh[end][start]=1;
            }
        }//初始化地图
        backtrace(1,z);

    }

    private static void backtrace(int t, int m) {
        if(t>x) {
            for(int h=1;h<=x;h++) {
                System.out.print(colors[h]+" ");
            }
            System.out.println();
        }else {
            for(int i=1;i<=m;i++) {
                if(check(t,i)==1) {
                    colors[t]=i;
                    backtrace(t+1,m);
                }
            }
        }

    }

    private static int check(int t, int i) {
        for(int k=1;k<t;k++) {
            if(grh[t][k]==1&&colors[k]==i) {
                return 0;
            }
        }
        return 1;

    }

}
