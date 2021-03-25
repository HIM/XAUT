package Arithmetic;
import java.util.*;
public class t2_1_01bag {
    static void initial(int[][] dp,int[] v,int bag){
        for(int i=0;i<v.length;i++){
            for(int j=0;j<=bag;j++){
                dp[i][j] = 0;
            }
        }
    }
    static void DP(int[] v,int[] w,int bag,int[][] dp,int[] flag){
        for(int i=1;i<=v.length-1;i++){
            for(int j=1;j<=bag;j++){
                if(j<w[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }

        int j = bag;
        for(int i=v.length-1;i>0;i--){
            if(dp[i][j]>dp[i-1][j]){
                flag[i] = 1;
                j = j - w[i];
            }
        }

    }
    public static void main(String[] args) {
        int[] w = {0,2,3,4,5};
        int[] v = {0,3,4,5,6};
        int bag = 8;
        int[][] dp = new int[v.length][bag+1];
        int[] flag = new int[v.length+1];
        Arrays.fill(flag,0);
        initial(dp,v,bag);
        DP(v,w,bag,dp,flag);
        System.out.println("动态规划表如下：");
        for(int i=0;i<v.length;i++){
            for(int j=0;j<=bag;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("背包内物品编号为：");
        for(int i=0;i<flag.length;i++){
            if(flag[i]==1)
                System.out.print(i+" ");
        }
    }
}
