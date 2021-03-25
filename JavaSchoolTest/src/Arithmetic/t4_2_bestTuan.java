package Arithmetic;

public class t4_2_bestTuan {

    static Gragh a;
    static int n;   //顶点数
    static int nowAnswer[]; //当前解
    static int nowPointN; //当前顶点数量
    static int nowMostPointN; //当前子图最多顶点
    static int nowBestAnswer[]; //当前可能最优解

    static void backTrack(int t){
        if(t>n-1){
            for(int j=0;j<n;j++){
                nowBestAnswer[j] = nowAnswer[j];
            }
            nowMostPointN = nowPointN;
            return;
        }else {
            int flag = check(t);
            if(flag==1){    //第t个点有边
                nowPointN++;
                nowAnswer[t] = 1;
                backTrack(t+1);
                nowPointN--;
            }else {    //第t个点无边
                nowAnswer[t] = 0;
                backTrack(t+1);
            }
        }
    }

    static int check(int t){
        int k = 1;
        for(int j=0;j<t;j++){
            if(nowAnswer[j]==1&&a.p[t].reach[j]!=1){
                k = 0;
                break;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int x[][] = {{1,1,0,1,1},
                     {1,1,1,0,1},
                     {0,1,1,0,1},
                     {1,0,0,1,1},
                     {1,1,1,1,1}};
        n = x.length;
        a = new Gragh(x,n);
        nowAnswer = new int[n];
        nowBestAnswer = new int[n];
        nowPointN = 0;
        nowMostPointN = 0;
        nowAnswer[0] = 1;
        backTrack(0);
        System.out.println("最大团中的点为：");
        for(int i=0;i<n;i++){
            if(nowBestAnswer[i]==1){
                System.out.print((i+1)+" , ");
            }
        }
    }
}

class Gragh{
    Point[] p;
    Gragh(int[][] x,int n){
        p = new Point[n];
        for(int i=0;i<n;i++){
            p[i] = new Point(x[i]);
        }
    }
}

class Point{
    int[] reach;
    Point(int[] x){
        this.reach = x;
    }
}