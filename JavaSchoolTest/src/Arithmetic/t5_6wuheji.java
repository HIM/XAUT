import java.util.Scanner;
public class t5_6wuheji {
    private static int n,k;
    private static int MAX = 14;
    private static int[][] sum;
    private static boolean[][] s;
    private static int[] t;

    private static int[] bestx;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while (true){
            k = 0;

            n = input.nextInt();

            s = new boolean[n+1][MAX];
            sum = new int[n+1][MAX];
            t = new int[MAX];
            bestx = new int[MAX];

            search(1);

            System.out.println(k-1);
            for(int i=n; i>=1; i--){
                for(int j=1; j<=k-1; j++)
                    if(bestx[j] == i)
                        System.out.print(j+" ");
                System.out.println();
            }
        }
    }

    private static boolean search(int dep){
        if(dep >= k) {
            k = dep;
            for(int i=1; i<=k-1; i++)
                bestx[i] = t[i];
        }

        if(dep > MAX)
            return true;

        for(int i=1; i<=n; i++){
            if(sum[i][dep] == 0){
                t[dep] = i;
                s[i][dep] = true;
                for(int j=1; j<dep; j++)
                    if(s[i][j])
                        sum[i][dep+j]++;
                if(search(dep+1))
                    return true;
                s[i][dep] = false;
                t[dep] = 0;
                for(int j=1; j<dep; j++)
                    if(s[i][j])
                        sum[i][dep+j]--;
            }
        }

        return false;
    }
}
